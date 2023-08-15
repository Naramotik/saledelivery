package ru.murza.saledelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.murza.saledelivery.models.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
}
