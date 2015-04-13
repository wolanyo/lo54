package fr.utbm.lo54.coursesmanager.core.controller;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Client;
import fr.utbm.lo54.coursesmanager.core.service.ClientService;

public class ClientController {

    public static void saveClient( Client client ) {
        ClientService clientService = new ClientService();
        clientService.createClient( client );
    }

    public List<Client> showListClients() {
        ClientService clientService = new ClientService();
        List<Client> clientsList = clientService.getListClients();
        return clientsList;

    }

}
