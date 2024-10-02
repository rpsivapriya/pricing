package com.pricing;




import java.util.List;

import com.pricing.model.Product;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
