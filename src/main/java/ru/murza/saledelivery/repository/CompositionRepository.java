package ru.murza.saledelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.murza.saledelivery.models.Composition;

@Repository
public interface CompositionRepository extends CrudRepository<Composition, Long> {
}
