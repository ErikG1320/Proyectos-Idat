package com.tiendaimg.tienda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendaimg.tienda.Entity.Product;

@Controller
@RequestMapping ("/products")
public class ProductsController {
    @Autowired
    private Product repo;
    @GetMapping ({"products","/"})
    public String mostrarProductos (Model model)
    {
        List<Product> products = repo.findAll();
        model.addAttribute("products",products);
        return "products/index";
    }
}
