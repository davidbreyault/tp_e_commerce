package fr.david.ecommerce.controller;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.service.ClientService;
import fr.david.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/clients")
    public List<Client> getAllClients() {
        System.out.println("/clients : get all clients");
        return clientService.getAllClient();
    }

    @GetMapping("/client")
    public Optional<Client> findClientByUsername(@RequestParam String username) throws RessourceNotFoundException {
        System.out.println("/client : get one client named : " + username + ".");
        return clientService.findClientByUsername(username);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        System.out.println("/orders : get all orders");
        System.out.println(orderService.getAllOrders());
        return orderService.getAllOrders();
    }
}
