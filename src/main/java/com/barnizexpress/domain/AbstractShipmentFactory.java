package com.barnizexpress.domain;

abstract class AbstractShipmentFactory implements ShipmentFactory {

    @Override
    public Shipment createBaseShipment(Product product, String city, String country) {
        return new BaseShipment(product, city, country);
    }

    @Override
    public Shipment createDecorator(
            OptionCode option, Shipment shipment, long declaredValueCop, String giftMessage) {
        return switch (option) {
            case FRAGILE -> new FragilePackagingDecorator(shipment);
            case INSURANCE -> new InsuranceDecorator(shipment, declaredValueCop);
            case CUSTOMS -> createCustomsDecorator(shipment);
            case GIFT -> new GiftWrapDecorator(shipment, giftMessage.trim());
            case EXPRESS -> new ExpressDecorator(shipment);
        };
    }

    protected Shipment createCustomsDecorator(Shipment shipment) {
        throw new IllegalArgumentException("This shipment factory does not support customs");
    }
}
