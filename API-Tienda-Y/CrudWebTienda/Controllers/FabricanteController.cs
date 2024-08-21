using CrudWebTienda.Models;
using CrudWebTienda.Models.DTO;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CrudWebTienda.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class FabricanteController : ControllerBase
    {
        private readonly TiendaContext _con;

        public FabricanteController(TiendaContext con)
        {
            _con = con;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<FabricanteDTO>>> GetFabricante()
        {
            return await _con.Fabricantes.Include(f => f.Productos).Select(f => new FabricanteDTO
            {
                CodF = f.IdFab,
                Nombre = f.Nombre,
            })
            .ToListAsync();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<FabricanteDTO>> GetFabricanteById(int id)
        {
            var fabricante = await _con.Fabricantes.Include(f => f.Productos).Select(f => new FabricanteDTO
            {
                CodF = f.IdFab,
                Nombre = f.Nombre,
            }).FirstOrDefaultAsync(f => f.CodF == id);

            if (fabricante == null)
            {
                return NotFound();
            }

            return fabricante;
        }

        [HttpGet("Producto/{NombreProducto}")]
        public async Task<ActionResult<IEnumerable<FabricanteDTO>>> GetFabricanteByProductName(string NombreProducto)
        {
            var fabricantes = await _con.Fabricantes.Include(f => f.Productos).Where(f => f.Productos.Any(p => p.Nombre.Contains(NombreProducto))).Select(f => new FabricanteDTO
            {
                CodF = f.IdFab,
                Nombre = f.Nombre,
            }).ToListAsync();

            if (fabricantes == null || fabricantes.Count == 0)
            {
                return NotFound();
            }

            return fabricantes;
        }

        [HttpPost]
        public async Task<ActionResult<Fabricante>> PostFabricante(FabricanteDTO fabricanteDto)
        {
            var fabricante = new Fabricante
            {
                Nombre = fabricanteDto.Nombre
            };

            _con.Fabricantes.Add(fabricante);
            await _con.SaveChangesAsync();

            return CreatedAtAction(nameof(GetFabricanteById), new { id = fabricante.IdFab }, fabricante);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateFabricante(int id, FabricanteDTO fabricanteDto)
        {
            var fabricante = await _con.Fabricantes.FindAsync(id);
            if (fabricante == null)
            {
                return NotFound();
            }

            fabricante.Nombre = fabricanteDto.Nombre;
            _con.Entry(fabricante).State = EntityState.Modified;

            try
            {
                await _con.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!FabricanteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult<Fabricante>> DeleteFabricante(int id)
        {
            var fabricante = await _con.Fabricantes.FindAsync(id);
            if (fabricante == null)
            {
                return NotFound();
            }

            _con.Fabricantes.Remove(fabricante);
            try
            {
                await _con.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!FabricanteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return fabricante;
        }

        private bool FabricanteExists(int id)
        {
            return _con.Fabricantes.Any(e => e.IdFab == id);
        }
    }
}
