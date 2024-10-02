package com.pricing;

import java.util.List;

import com.pricing.model.Product;

public interface PricingStrategy
{
    double calculateTotal(List<Product> products);
}
