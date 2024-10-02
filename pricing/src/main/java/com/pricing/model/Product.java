package com.pricing.model;


public class Product {
 private String name;
 private double price;
 private int dealThreshold;
 private double dealPrice;

 public Product(String name, double price) {
     this.name = name;
     this.price = price;
    
 }
 public Product(String name, double price, int dealThreshold, double dealPrice) {
     this.name = name;
     this.price = price;
     this.dealThreshold = dealThreshold;
     this.dealPrice = dealPrice;
 }
 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

 public int getDealThreshold() {
     return dealThreshold;
 }

 public double getDealPrice() {
     return dealPrice;
 }
}


