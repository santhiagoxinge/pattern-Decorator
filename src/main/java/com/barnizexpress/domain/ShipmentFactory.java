package com.barnizexpress.domain;

/** Abstract factory for the shipment and option decorators of a destination family. */
public interface ShipmentFactory {

    boolean supportsDestination(String country);

    boolean supports(OptionCode option);

    Shipment createBaseShipment(Product product, String city, String country);

    Shipment createDecorator(
            OptionCode option, Shipment shipment, long declaredValueCop, String giftMessage);
}
