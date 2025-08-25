package com.sinse.restaurant.model.store;

import com.sinse.restaurant.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Store createStore(String name, String address) {
        Store store = new Store();
        store.setName(name);
        store.setAddress(address);
        return storeRepository.save(store);
    }

    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }
}
