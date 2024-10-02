package com.pricing.controllers;

import java.util.List;

import com.pricing.PricingStrategy;
import com.pricing.model.Product;

public class PricingService {
    private PricingStrategy strategy;

    public PricingService(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(List<Product> products) {
        return strategy.calculateTotal(products);
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }
}
