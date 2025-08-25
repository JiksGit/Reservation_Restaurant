package com.sinse.restaurant.model.store;

import com.sinse.restaurant.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByNameContaining(String keyword);
}