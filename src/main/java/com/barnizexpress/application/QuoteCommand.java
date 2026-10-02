package com.barnizexpress.application;

import java.util.List;

/** What the customer asked for: a piece, a destination and a set of option codes. */
public record QuoteCommand(
        String productId,
        String city,
        String country,
        Long declaredValueCop,
        List<String> options,
        String giftMessage) {

    public QuoteCommand {
        options = options == null ? List.of() : List.copyOf(options);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String productId;
        private String city;
        private String country;
        private Long declaredValueCop;
        private List<String> options = List.of();
        private String giftMessage;

        private Builder() {}

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder declaredValueCop(Long declaredValueCop) {
            this.declaredValueCop = declaredValueCop;
            return this;
        }

        public Builder options(List<String> options) {
            this.options = options;
            return this;
        }

        public Builder giftMessage(String giftMessage) {
            this.giftMessage = giftMessage;
            return this;
        }

        public QuoteCommand build() {
            return new QuoteCommand(
                    productId, city, country, declaredValueCop, options, giftMessage);
        }
    }
}