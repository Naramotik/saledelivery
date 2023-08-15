package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Client;
import ru.murza.saledelivery.models.ManagerInfo;
import ru.murza.saledelivery.models.Roles;
import ru.murza.saledelivery.repository.ClientRepository;
import ru.murza.saledelivery.repository.RolesRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RolesService rolesService;

    public Client saveCustomer(Client client){
        Roles consumerRole = rolesService.getRole("ROLE_CUSTOMER");
        client.setRole(consumerRole);
        return clientRepository.save(client);
    }

    public Client updateToManager(Long clientId, Client clientWithManagerInfo){
        Roles managerRole = rolesService.getRole("ROLE_MANAGER");
        Client client = patcher(clientId, clientWithManagerInfo);
        client.setManagerInfo(clientWithManagerInfo.getManagerInfo());
        client.setRole(managerRole);
        return clientRepository.save(client);
    }

    public Client updateClient(Long clientId, Client patch){
        return clientRepository.save(patcher(clientId, patch));
    }


    public void deleteClient(Client client){
        clientRepository.delete(client);
    }


    public Client patcher(Long clientId, Client patch){
        Client client = clientRepository.findById(clientId).get();

        if (patch.getName() != null && !patch.getName().equals(client.getName()))
            client.setName(patch.getName());

        if (patch.getPassword() != null && !patch.getPassword().equals(client.getPassword()))
            client.setPassword(patch.getPassword());

        if (patch.getManagerInfo() != null && !patch.getManagerInfo().equals(client.getManagerInfo())){
            client.setManagerInfo(patch.getManagerInfo());
        }
        return client;
    }
}
