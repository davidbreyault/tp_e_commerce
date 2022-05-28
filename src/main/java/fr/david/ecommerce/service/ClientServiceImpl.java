package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.model.Client;
import fr.david.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) throws RessourceNotFoundException {
        return clientRepository.getById(clientId);
    }

    @Override
    public Client save(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Optional<Client> findClientByUsername(String username) throws RessourceNotFoundException {
        Optional<Client> client = clientRepository.findByUsername(username);
        if (client.isPresent()) {
            return client;
        } else {
            throw new RessourceNotFoundException("Client not found !");
        }
    }
}
