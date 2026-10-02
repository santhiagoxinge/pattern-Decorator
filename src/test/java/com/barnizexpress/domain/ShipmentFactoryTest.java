package com.barnizexpress.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShipmentFactoryTest {

    private static final Product PRODUCT =
            new Product("tray", "Tray", "", 185000L, 2.5, "/images/tray.jpg");

    @Test
    @DisplayName("selects a domestic family for Colombia and excludes customs")
    void domesticFactorySupportsDomesticDestinations() {
        ShipmentFactory factory = new DomesticShipmentFactory();

        assertTrue(factory.supportsDestination("Colombia"));
        assertFalse(factory.supports(OptionCode.CUSTOMS));
        assertInstanceOf(BaseShipment.class, factory.createBaseShipment(PRODUCT, "Pasto", "Colombia"));
    }

    @Test
    @DisplayName("selects an international family that can create customs decorators")
    void internationalFactoryCreatesCustoms() {
        ShipmentFactory factory = new InternationalShipmentFactory();
        Shipment base = factory.createBaseShipment(PRODUCT, "Quito", "Ecuador");

        assertTrue(factory.supportsDestination("Ecuador"));
        assertTrue(factory.supports(OptionCode.CUSTOMS));
        assertInstanceOf(
                CustomsDecorator.class,
                factory.createDecorator(OptionCode.CUSTOMS, base, 0L, null));
    }
}
