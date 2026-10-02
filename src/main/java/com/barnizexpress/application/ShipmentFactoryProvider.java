package com.barnizexpress.application;

import com.barnizexpress.domain.ShipmentFactory;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShipmentFactoryProvider {

    private final List<ShipmentFactory> factories;

    public ShipmentFactoryProvider(List<ShipmentFactory> factories) {
        this.factories = List.copyOf(factories);
    }

    public ShipmentFactory forDestination(String country) {
        return factories.stream()
                .filter(factory -> factory.supportsDestination(country))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No shipment factory supports destination country: " + country));
    }
}
