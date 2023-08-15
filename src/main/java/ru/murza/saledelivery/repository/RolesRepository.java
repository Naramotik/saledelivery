package ru.murza.saledelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.murza.saledelivery.models.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {
    Roles findByTitle(String title);
}

