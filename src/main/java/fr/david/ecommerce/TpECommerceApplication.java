package fr.david.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("fr.*")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TpECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpECommerceApplication.class, args);
    }
}
