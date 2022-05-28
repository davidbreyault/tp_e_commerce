package fr.david.ecommerce.controller;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/clients")
    public List<Client> getAllClients(Model model) {
        System.out.println("/clients : get all clients");
        return clientService.getAllClient();
    }

    @GetMapping("/client")
    public Optional<Client> findClientByUsername(@RequestParam String username) throws RessourceNotFoundException {
        return clientService.findClientByUsername(username);
    }
}
