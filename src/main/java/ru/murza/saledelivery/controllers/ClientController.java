package ru.murza.saledelivery.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.murza.saledelivery.models.Client;
import ru.murza.saledelivery.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client saveCustomer(@Valid @RequestBody Client client){
        return clientService.saveCustomer(client);
    }

//    @GetMapping
//    public Client getCustomer(){
//        return clientService.getCustomer().get();
//    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateToManager(@PathVariable("clientId") Long clientId,
                                                  @RequestBody Client clientWithManagerInfo){
        return new ResponseEntity<>(clientService.updateToManager(clientId, clientWithManagerInfo), HttpStatus.OK);
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable("clientId") Long clientId,
                                               @RequestBody Client patch){
        return new ResponseEntity<>(clientService.updateClient(clientId, patch), HttpStatus.OK);
    }
}
