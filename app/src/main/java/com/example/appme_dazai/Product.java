package com.example.appme_dazai;

public class Product {
    private String name;
    private String price;
    private String description;

    //Constructor
    public Product(String name,String price,String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //Các hàm Getter
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
}
