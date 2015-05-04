package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Client;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateClientDAO;
import java.util.ArrayList;
import java.util.Set;

public class ClientService {

    // service to get the list of Client
    public List<Client> getListClients() {
        HibernateClientDAO hibernateclientDao = new HibernateClientDAO();
       // List<Client> clientsList = (List<Client>) hibernateclientDao.getList();
        Set<Client> r = hibernateclientDao.getList();
        List<Client> clientsList = new ArrayList<Client>();
        clientsList.addAll(r);
        return clientsList;
    }

    // service to create Client
    public void createClient(Client client) {
        HibernateClientDAO hibernateclientDao = new HibernateClientDAO();
        hibernateclientDao.create(client);
    }

}
