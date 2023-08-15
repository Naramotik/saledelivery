package ru.murza.saledelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Store;
import ru.murza.saledelivery.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll(){
        List<Store> stores = new ArrayList<>();
        storeRepository.findAll().forEach(stores::add);
        return stores;
    }

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public void deleteById(Long storeId){
        storeRepository.deleteById(storeId);
    }
}
