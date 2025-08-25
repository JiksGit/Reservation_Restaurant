package com.sinse.restaurant.controller;

import com.sinse.restaurant.domain.Store;
import com.sinse.restaurant.model.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor
class StoreServiceTest {

    private final StoreService storeService;

    @Test
    void testCreateStore() {
        Store store = storeService.createStore("맛집1", "서울 강남");
        assertNotNull(store.getId());
        assertEquals("맛집1", store.getName());
    }
}