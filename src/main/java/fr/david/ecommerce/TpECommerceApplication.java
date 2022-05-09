package fr.david.ecommerce;

import fr.david.ecommerce.model.Product;
import fr.david.ecommerce.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class TpECommerceApplication {

    public static void main(String[] args) {
        // SpringApplication.run(CdaECommerceApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        // Récupération de l'instance de type ProductService créé par le bean
        ProductService productService = context.getBean("products", ProductService.class);

        Product product1 = new Product(1l, "Produit 1", "Description du produit 1", 12d, "url1", 1);
        Product product2 = new Product(2l, "Produit 2", "Description du produit 2", 32d, "url2", 4);
        Product product3 = new Product(3l, "Produit 3", "Description du produit 3", 22d, "url3", 54);
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        productService.getAllProducts().stream().forEach(System.out::println);
    }
}
