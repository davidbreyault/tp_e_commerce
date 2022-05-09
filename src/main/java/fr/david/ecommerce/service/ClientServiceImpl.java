package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final List<Client> allClient = new ArrayList<>();

    @Override
    public List<Client> getAllClient() {
        return allClient;
    }

    @Override
    public Client getClientById(Long clientId) throws RessourceNotFoundException {
        return allClient.stream().filter(c -> c.getId().equals(clientId)).findFirst()
            .orElseThrow(() -> new RessourceNotFoundException("Client not found"));
    }

    @Override
    public Client save(Client client) {
        allClient.add(client);
        return client;
    }
}
