package com.github.naomisoubhia.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductIdentifierId implements Serializable {
    private String product;
    private String identifier;

    // Constructor, equals and hashCode methods

    public ProductIdentifierId(String product, String identifier) {
        this.product = product;
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIdentifierId that = (ProductIdentifierId) o;
        return Objects.equals(product, that.product) && Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, identifier);
    }
}
