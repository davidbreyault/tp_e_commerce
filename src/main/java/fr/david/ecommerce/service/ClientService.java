package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long clientId) throws RessourceNotFoundException;
    public Client save(Client client);
}
