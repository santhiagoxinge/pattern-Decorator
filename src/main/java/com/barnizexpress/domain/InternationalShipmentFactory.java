package com.barnizexpress.domain;

import java.util.Locale;
import org.springframework.stereotype.Component;

/** Creates shipments for destinations outside Colombia, including customs clearance. */
@Component
public class InternationalShipmentFactory extends AbstractShipmentFactory {

    @Override
    public boolean supportsDestination(String country) {
        return country != null && !country.trim().isEmpty()
                && !country.trim().toLowerCase(Locale.ROOT).equals("colombia");
    }

    @Override
    public boolean supports(OptionCode option) {
        return true;
    }

    @Override
    protected Shipment createCustomsDecorator(Shipment shipment) {
        return new CustomsDecorator(shipment);
    }
}
