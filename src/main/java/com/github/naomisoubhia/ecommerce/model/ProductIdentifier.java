package com.github.naomisoubhia.ecommerce.model;

import com.github.naomisoubhia.ecommerce.model.Product;
import com.github.naomisoubhia.ecommerce.model.ProductIdentifierId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_identifiers")
@IdClass(ProductIdentifierId.class)
public class ProductIdentifier {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    private String identifier;

    // Getters and setters
}

