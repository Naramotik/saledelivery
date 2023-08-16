package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.enums.ClientRoles;
import ru.murza.saledelivery.models.Client;
import ru.murza.saledelivery.models.Roles;
import ru.murza.saledelivery.repository.ClientRepository;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RolesService rolesService;

    public Client saveCustomer(Client client){
        Roles consumerRole = rolesService.getRole(ClientRoles.ROLE_CUSTOMER.toString());
        client.setRole(consumerRole);
        return clientRepository.save(client);
    }

    public Client updateToManager(Long clientId, Client clientWithManagerInfo){
        Client client = patcher(clientId, clientWithManagerInfo);
        client.setManagerInfo(clientWithManagerInfo.getManagerInfo());
        Roles managerRole = rolesService.getRole(ClientRoles.ROLE_MANAGER.toString());
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
        Client client = clientRepository.findById(clientId).get();                                      //TODO EXCEPTION   TODO EXCEPTION   TODO EXCEPTION

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
