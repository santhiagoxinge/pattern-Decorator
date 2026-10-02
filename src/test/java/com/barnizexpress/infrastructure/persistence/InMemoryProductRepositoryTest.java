package com.barnizexpress.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import com.barnizexpress.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InMemoryProductRepositoryTest {

    private final InMemoryProductRepository repository = new InMemoryProductRepository();

    @Test
    @DisplayName("returns prototype copies from product lookups")
    void returnsProductCopy() {
        Product first = repository.findById("tray-giralda").orElseThrow();
        Product second = repository.findById("tray-giralda").orElseThrow();

        assertNotSame(first, second);
        assertEquals(first, second);
    }
}
