using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using NeptunoWebApi.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace NeptunoWebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class NeptunoAPIController : ControllerBase
    {
        private readonly Neptuno2023Context ctx;
        public NeptunoAPIController(Neptuno2023Context _ctx)
        {
            ctx = _ctx;
        }


        // GET: api/<NeptunoAPIController>
        [HttpGet("GetCategorias")]
        public List<Categoria> GetCategorias()
        {
            return ctx.Categorias.ToList();
        }

        [HttpGet("GetEmpleados")]
        public List<Empleado> GetEmpleados()
        {
            return ctx.Empleados.ToList();
        }

        [HttpGet("GetClientes")]
        public List<Cliente> GetClientes()
        {
            return ctx.Clientes.ToList();
        }

        // GET api/<NeptunoAPIController>/5
        [HttpGet("GetPedidosEmp/{id}")]
        public List<Pedido> GetPedidosEmp(int id)
        {
            return ctx.Pedidos.Where(p=>p.IdEmpleado==id).ToList();
        }

        // GET api/<NeptunoAPIController>/5
        [HttpGet("GetPedidosClienteAnio/{id}/{anio}")]
        public List<pa_pedidos_cliente_anio> GetPedidosClienteAnio(string id="", int anio=0)
        {
            var listado = ctx.pa_pedidos_cliente_anio
                             .FromSqlRaw<pa_pedidos_cliente_anio>(
                                 "pa_pedidos_cliente_anio {0}, {1}", id, anio)
                             .ToList();
            //
            return listado;
        }

        // POST api/<NeptunoAPIController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<NeptunoAPIController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<NeptunoAPIController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
