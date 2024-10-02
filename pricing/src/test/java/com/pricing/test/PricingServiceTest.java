package com.pricing.test;


import java.util.List;
import java.util.Arrays;
import org.junit.Test;

import com.pricing.DealPricingStrategy;
import com.pricing.DefaultPricingStrategy;




import com.pricing.controllers.PricingService;
import com.pricing.model.Product;
import static org.junit.Assert.*;
public class PricingServiceTest {

	void PricingServiceTest()
	{
		
	}
    @Test
    public void testDefaultPricing() {
        PricingService pricingService = new PricingService(new DefaultPricingStrategy());
        Product apple = new Product("Apple", 1.00);
        List<Product> products = Arrays.asList(apple, apple, apple);
        double total = pricingService.calculateTotal(products);
        System.out.println("default "+total);
        assertEquals(3.00, total, 0.01); // Default pricing should be $3.00
    }

    @Test
    public void testDealPricing() {
        PricingService pricingService = new PricingService(new DealPricingStrategy());
        Product apple = new Product("Apple", 1.00, 3, 2.50); // Buy 3 for $2.50
        Product banana = new Product("Banana", 0.50, 2,0.80); // buy 3 for 1.00
        List<Product> products = Arrays.asList(apple, apple,banana, apple,banana,banana); //  3 apples, 3 banana
        //  3 apples (2.50), 3 banana(0.80+0.50)
        double total = pricingService.calculateTotal(products);
        System.out.println("deal "+total);
        assertEquals(3.80, total, 0.01);
    }

    @Test
    public void testMixedStrategies() {
        PricingService pricingService = new PricingService(new DealPricingStrategy());
        Product apple = new Product("Apple", 1.00, 3, 2.50);
        Product banana = new Product("Banana", 0.50, 3,1.00); 
        
        Product orange = new Product("Orange", 0.50); 
        
        List<Product> products = Arrays.asList(apple, apple, banana,apple,orange,banana,banana,banana,banana,apple);   // 4 apple, 5 banana, 1 orange
     // 4 apple (2.5+1), 5 banana (1+1),  1 orange (0.5)
        double total = pricingService.calculateTotal(products);
        System.out.println("mixed "+total);
        assertEquals(6.00, total, 0.01); 
        products=Arrays.asList(apple, apple, banana,orange,banana); // 2 apple, 2 banana, 1 orange
        // 2 apple (2), 2 banana (1), 1 orange (0.5)
        total = pricingService.calculateTotal(products);
        System.out.println("mixed "+total);
        assertEquals(3.50, total, 0.01); // Should not apply deal
    }
   
}
