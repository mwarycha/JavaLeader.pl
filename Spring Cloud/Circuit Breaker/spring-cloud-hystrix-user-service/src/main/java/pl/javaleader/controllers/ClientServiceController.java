package pl.javaleader.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.javaleader.model.Client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientServiceController {

    private static List<Client> clients;

    static {
        clients = new ArrayList();

        Client firstClient = new Client("James", "Spring");
        clients.add(firstClient);

        Client secondClient = new Client("Thomas", "Dummy");
        clients.add(secondClient);

    }

    @RequestMapping(value = "/getClientDetails/{clientId}", method = RequestMethod.GET)
    public Client getClient(@PathVariable int clientId) {
        Client findClient = clients.get(clientId);
        if (findClient == null) {
            findClient = new Client("Not Found", "N/A");
        }
        return findClient;
    }
}