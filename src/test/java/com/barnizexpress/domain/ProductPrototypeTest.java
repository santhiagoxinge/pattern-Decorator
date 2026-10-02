package com.barnizexpress.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductPrototypeTest {

    @Test
    @DisplayName("copies a product prototype without sharing the product instance")
    void copiesProduct() {
        Product prototype =
                new Product("tray", "Tray", "Handcrafted tray", 185000L, 2.5, "/images/tray.jpg");

        Product copy = prototype.copy();

        assertNotSame(prototype, copy);
        assertEquals(prototype, copy);
    }
}
