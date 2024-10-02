package com.pricing;

import java.util.HashMap;

import java.util.List;

import com.pricing.model.Product;

public class DealPricingStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(List<Product> products) {
        double total = 0;
       
        HashMap<String,Integer> productCnt=new HashMap<>();
        
        for (Product product : products) {
        	
        	productCnt.put(product.getName(), productCnt.getOrDefault(product.getName(),0)+1);
        	
             //count++;
        	
            total += product.getPrice();
            
            // Check for deal
           // System.out.println(productCnt.get(product.getName()) +" "+product.getDealThreshold()+" "+product.getName());
            
            if (product.getDealThreshold()!=0 && productCnt.get(product.getName()) % product.getDealThreshold() == 0) {
                total -= (product.getPrice() * product.getDealThreshold() - product.getDealPrice());
            }
        }

        return total;
    }
}
