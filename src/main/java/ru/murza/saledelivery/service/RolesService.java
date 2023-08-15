package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Roles;
import ru.murza.saledelivery.repository.RolesRepository;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public Roles getRole(String role){
        return rolesRepository.findByTitle(role);
    }
}
