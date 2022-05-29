package fr.david.ecommerce;

import fr.david.ecommerce.model.Product;
import fr.david.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("fr.*")
@SpringBootApplication()
public class TpECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpECommerceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(ProductService productService) {
//        return args -> {
//            Product product1 = new Product(
//                    1l,
//                    "Classico",
//                    "The safe bet ! You will never be disappointed with this one ! The basic ingredients that make a sandwich a success for sure !",
//                    9d,
//                    "../../resources/images/classic-burger.jpg",
//                    2);
//
//            Product product2 = new Product(
//                    2l,
//                    "Mister Bite",
//                    "Discover the real French \"croque monsieur\", accompanied by its melted cheese on its slices of high quality hams. Quick, simple, and easy to eat.",
//                    7d,
//                    "../../resources/images/croque-monsieur.jpg",
//                    4);
//
//            Product product3 = new Product(
//                    3l,
//                    "Bacon Cheese",
//                    "Adding good bacon that has been fried until almost crispy is an excellent addition, to anything really. But on a cheeseburger ? Oh man. Now we’re talking.",
//                    11d,
//                    "../../resources/images/bacon-cheese-burger.jpg",
//                    8);
//
//            Product product4 = new Product(
//                    4l,
//                    "Salmon Bagel",
//                    "Starting with smoked salmon, this bagel sandwich is layered with tasty ingredients flavored cream cheese, capers, and purple onion. It's a quick fix for a brown-bag lunch.",
//                    13d,
//                    "../../resources/images/bagel-salmon.jpg",
//                    3);
//
//            Product product5 = new Product(
//                    5l,
//                    "Big One",
//                    "The big one is a must in the house!\n" +
//                            "With its two steaks and homemade burger sauce, it is an all-time favourite ! It will satisfy your wolf hunger, and your gluttony !",
//                    13d,
//                    "../../resources/images/big-burger.jpg",
//                    3);
//
//            productService.save(product1);
//            productService.save(product2);
//            productService.save(product3);
//            productService.save(product4);
//            productService.save(product5);
//        };
//    }
}
