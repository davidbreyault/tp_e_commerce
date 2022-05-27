package fr.david.ecommerce.controller;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{productId}")
    public String getProductById(Model model, @PathVariable("productId") Long id) throws RessourceNotFoundException {
        model.addAttribute("product", productService.getProductById(id));
        System.out.println("/sandwiches/id : get product by id (" + id + ")");
        return "product";
    }
}
