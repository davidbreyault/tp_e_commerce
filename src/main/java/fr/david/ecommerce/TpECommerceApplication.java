package fr.david.ecommerce;

import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.model.OrderProduct;
import fr.david.ecommerce.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

//@SpringBootApplication
public class TpECommerceApplication {

    public static void main(String[] args) {
        // SpringApplication.run(CdaECommerceApplication.class, args);

        Product product1 = new Product(1l, "Sandwich 1", "Desc du sandwich 1", 7d, "url1", 3);
        Product product2 = new Product(2l, "Sandwich 2", "Desc du sandwich 2", 8d, "url2", 4);
        Product product3 = new Product(3l, "Sandwich 3", "Desc du sandwich 3", 12d, "url3", 54);

        Client client = new Client(1l, "David", "Toto37");

        Order order = new Order(1L, LocalDate.now(), null, client, new ArrayList<OrderProduct>());

        order.addProduct(product1, 2);
        order.addProduct(product2, 1);
        order.setStatus("Payée");

        System.out.println(order);
    }
}
