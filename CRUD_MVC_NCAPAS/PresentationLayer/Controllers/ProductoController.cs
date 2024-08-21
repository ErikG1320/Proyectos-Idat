using BusinessLayer;
using DataAccess;
using Microsoft.AspNetCore.Mvc;

namespace PresentationLayer.Controllers
{
    public class ProductoController(ProductoService productoService) : Controller
    {
        private readonly ProductoService _productoService = productoService;

        public IActionResult Index()
        {
            var Productos = _productoService.GetAllProductos();
            return View(Productos);
        }
        public IActionResult Create()
        {
            return View();
        }
        [HttpPost]
        public IActionResult Create(Producto producto)
        {
            if (ModelState.IsValid)
            {
                _productoService.AddProducto(producto);
                return RedirectToAction("Index");
            }
            return View(producto);
        }
        public IActionResult Edit(int id)
        {
            var producto = _productoService.GetProductoById(id);
            if (producto == null)
            {
                return NotFound();
            }
            return View(producto);
        }
        [HttpPost]
        public IActionResult Edit(Producto producto)
        {
            if (ModelState.IsValid)
            {
                _productoService.UpdateProducto(producto);
                return RedirectToAction("Index");
            }
            return View(producto);
        }
        public IActionResult Delete(int id)
        {
            var producto = _productoService.GetProductoById(id);
            if (producto == null)
            {
                return NotFound();
            }
            return View(producto);
        }
        [HttpPost,ActionName("Delete")]
        public IActionResult DeleteConfirmed(int id)
        {
            _productoService.DeleteProducto(id);
            return RedirectToAction("Index");
        }
    }
}