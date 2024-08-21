using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ServicioWebApiGaspar.Models;

[Route("api/[controller]")]
[ApiController]
public class PapeletaApiController : ControllerBase
{
    private readonly DbCon _context;

    public PapeletaApiController(DbCon context)
    {
        _context = context;
    }
    [HttpGet("Propietarios/{inicial}")]
    public async Task<ActionResult<IEnumerable<Propietario>>> GetPropietariosPorinicial(string inicial)
    {
        // Obtener los propietarios que empiezan con la letra dada
        var propietarios = await _context.Propietario
            .Where(p => p.Nombre.StartsWith(inicial))
            .ToListAsync();
        return Ok(propietarios);
    }
    [HttpGet("Papeletas/{dni}")]
    public async Task<ActionResult<IEnumerable<Papeleta>>> GetPapeletasNoPagadas(int dni)
    {
        // Obtener las papeletas por DNI
        var papeletas = await _context.Papeletas
            .Where(p => p.PropietarioId == dni && p.Estado == "No")
            .ToListAsync();
            await _context.SaveChangesAsync(); // Guardar los cambios en la base de datos
            return Ok(papeletas);
    }
    // PUT: api/Papeletas/{numeroPapeleta}
      [HttpPut("pagar/{numeropapeleta}")]
      public async Task<ActionResult> PagarPapeleta(int numeropapeleta)
      {
        var papeleta = await _context.Papeletas.FirstOrDefaultAsync(p =>p.Nro_Papeleta == numeropapeleta);
        if (papeleta == null)
        {
            return NotFound();
        }
        papeleta.Estado = "Pagado";
        papeleta.Fecha = DateTime.Now;

        _context.Entry(papeleta).State = EntityState.Modified;
        await _context.SaveChangesAsync();
        return Ok($"Papeleta:{numeropapeleta}, Fue Pagada correctamente");
      }
}