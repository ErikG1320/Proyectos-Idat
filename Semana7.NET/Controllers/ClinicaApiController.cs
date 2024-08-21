using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Semana7.NET.Models;

namespace Semana7.NET.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ClinicaApiController : ControllerBase
    {
        private readonly BdclinicaWebapiContext _ctx;

        public ClinicaApiController(BdclinicaWebapiContext ctx)
        {
            _ctx = ctx; // Corregir la asignación de la variable
        }

        [HttpGet("GetMedicos")]
        public async Task<ActionResult<List<Medico>>> GetMedicos()
        {
            try
            {
                var listado = await _ctx.Medicos.ToListAsync();
                return Ok(listado);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al obtener los médicos: {ex.Message}");
            }
        }

        [HttpPost("AgregarMedico")]
        public async Task<ActionResult<Medico>> AgregarMedico(Medico medico)
        {
            try
            {
                _ctx.Medicos.Add(medico);
                await _ctx.SaveChangesAsync();
                return CreatedAtAction(nameof(GetMedicos), new { id = medico.Codmed }, medico);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al agregar el médico: {ex.Message}");
            }
        }

        [HttpGet("GetMedicosEspecialidad/{id}")]
        public async Task<ActionResult<List<Medico>>> GetMedicosEspecialidad(string id)
        {
            try
            {
                var listado = await _ctx.MedicoEspecialidades.FromSql($"execute MedicosEspecialidad {id}").ToList();
                
                // var listado2 = await _ctx.MedicosEspecialidad.FromSql($"MedicosEspecialidad{0},id").ToList();
                return Ok(listado);

            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al obtener los médicos: {ex.Message}");
            }
        }
        [HttpPut("ActualizarMedico/{id}")]
        public async Task<ActionResult<Medico>> ActualizarMedico(int id, Medico medico)
        {
            try
            {
                if (id != int.Parse(medico.Codmed))
                    return BadRequest("El ID del médico no coincide con el ID proporcionado.");

                _ctx.Entry(medico).State = EntityState.Modified;
                await _ctx.SaveChangesAsync();
                return Ok(medico);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al actualizar el médico: {ex.Message}");
            }
        }
        [HttpDelete("EliminarMedico/{id}")]
        public async Task<ActionResult> EliminarMedico(int id)
        {
            try
            {
                var medico = await _ctx.Medicos.FindAsync(id);
                if (medico == null)
                    return NotFound();

                _ctx.Medicos.Remove(medico);
                await _ctx.SaveChangesAsync();
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al eliminar el médico: {ex.Message}");
            }
        }
    }
}
