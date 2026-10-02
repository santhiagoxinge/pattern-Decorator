package com.barnizexpress.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuoteCommandTest {

    @Test
    @DisplayName("builds an immutable quote command with the supplied options")
    void buildsImmutableCommand() {
        List<String> options = new ArrayList<>(List.of("FRAGILE"));

        QuoteCommand command =
                QuoteCommand.builder()
                        .productId("tray")
                        .city("Pasto")
                        .country("Colombia")
                        .options(options)
                        .build();
        options.add("EXPRESS");

        assertEquals(List.of("FRAGILE"), command.options());
    }
}
