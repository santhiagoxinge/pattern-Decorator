package com.barnizexpress.domain;

import java.util.Locale;
import org.springframework.stereotype.Component;

/** Creates shipments for destinations within Colombia. */
@Component
public class DomesticShipmentFactory extends AbstractShipmentFactory {

    @Override
    public boolean supportsDestination(String country) {
        return country != null && country.trim().toLowerCase(Locale.ROOT).equals("colombia");
    }

    @Override
    public boolean supports(OptionCode option) {
        return option != OptionCode.CUSTOMS;
    }
}
