package fr.david.ecommerce;

import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.model.OrderProduct;
import fr.david.ecommerce.model.Product;
import fr.david.ecommerce.service.ClientService;
import fr.david.ecommerce.service.OrderService;
import fr.david.ecommerce.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.ArrayList;

@ComponentScan("fr.*")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TpECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpECommerceApplication.class, args);
    }
}
