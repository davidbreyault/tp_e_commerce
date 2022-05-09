package fr.david.ecommerce;

import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.model.OrderProduct;
import fr.david.ecommerce.model.Product;
import fr.david.ecommerce.service.ClientService;
import fr.david.ecommerce.service.OrderService;
import fr.david.ecommerce.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;

//@SpringBootApplication
public class TpECommerceApplication {

    public static void main(String[] args) {
        // SpringApplication.run(CdaECommerceApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        // Récupération de l'instance de type ProductService créé par le bean
        ProductService productService = context.getBean("products", ProductService.class);
        ClientService clientService = context.getBean("clients", ClientService.class);
        OrderService orderService = context.getBean("orders", OrderService.class);

        Product product1 = new Product(1l, "Produit 1", "Description du produit 1", 12d, "url1", 1);
        Product product2 = new Product(2l, "Produit 2", "Description du produit 2", 32d, "url2", 4);
        Product product3 = new Product(3l, "Produit 3", "Description du produit 3", 22d, "url3", 54);
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        Client client1 = new Client(1l, "John_Doe", "helloworld");
        Client client2 = new Client(2l, "Jon_Hopkins", "ilovepiano");
        clientService.save(client1);
        clientService.save(client2);

        Order order = new Order(1l, LocalDate.now(), null, client1, new ArrayList<OrderProduct>());
        order.addProduct(product1, 2);
        order.addProduct(product3, 4);

        orderService.create(order);
        System.out.println(order);

        try {
            orderService.update(order);
        } catch (StockException e) {
            e.printStackTrace();
        }
        // Vérifiez qu’une commande ne passe pas à “Payée” si un produit n’est pas en quantité suffisante.
        System.out.println(order);
    }
}
