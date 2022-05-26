package fr.david.ecommerce.controller;

import fr.david.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sandwiches")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"", "/"})
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        System.out.println("/sandwiches : get all products !");
        return "products";
    }
}
