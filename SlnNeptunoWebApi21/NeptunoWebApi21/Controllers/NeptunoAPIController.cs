using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using NeptunoWebApi21.Models;
using Microsoft.EntityFrameworkCore;

namespace NeptunoWebApi21.Controllers
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
        public List<Categorias> GetCategorias()
        {
            return ctx.Categorias.ToList();
        }

        [HttpGet("GetEmpleados")]
        public List<Empleados> GetEmpleados()
        {
            return ctx.Empleados.ToList();
        }

        [HttpGet("GetClientes")]
        public List<Clientes> GetClientes()
        {
            return ctx.Clientes.ToList();
        }

        // GET api/<NeptunoAPIController>/5
        [HttpGet("GetPedidosEmp/{id}")]
        public List<Pedidos> GetPedidosEmp(int id)
        {
            return ctx.Pedidos.Where(p => p.IdEmpleado == id).ToList();
        }

        // GET api/<NeptunoAPIController>/5
        [HttpGet("GetPedidosClienteAnio/{id}/{anio}")]
        public List<pa_pedidos_cliente_anio> GetPedidosClienteAnio(string id = "", int anio = 0)
        {
            var listado = ctx.pa_pedidos_cliente_anio
                             .FromSql<pa_pedidos_cliente_anio>(
                                 "pa_pedidos_cliente_anio {0}, {1}", id, anio)
                             .ToList();
            //
            return listado;
        }





        // GET: api/NeptunoAPI
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/NeptunoAPI/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/NeptunoAPI
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT: api/NeptunoAPI/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
