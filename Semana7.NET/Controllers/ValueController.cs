using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace Semana7.NET
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValueController : ControllerBase
    {
        private readonly ILogger<ValueController> _logger;

        public ValueController(ILogger<ValueController> logger)
        {
            _logger = logger;
        }

        [HttpGet]
        public IActionResult Get()
        {
            // Implement your logic to get values
            return Ok("Hello from API!");
        }

        [HttpPost]
        public IActionResult Post([FromBody] string value)
        {
            // Implement your logic to create a new value
            return CreatedAtAction(nameof(Get), new { id = 1 }, value);
        }

        // Add other actions (PUT, DELETE) as needed
    }
}
