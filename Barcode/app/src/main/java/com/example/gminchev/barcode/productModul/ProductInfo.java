package com.example.gminchev.barcode.productModul;

/**
 * Created by GMinchev on 12.4.2018 г..
 */
class Product {

    String product_name;
    String ingredients_text;

    public String getProduct_name() {
        return product_name;
    }

    public String getIngredients_text() {
        return ingredients_text;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", ingredients_text='" + ingredients_text + '\'' +
                '}';
    }
}

public class ProductInfo {
    String code;
    Product product;
    String product_name;
    String ingredients_text;


    public String getCode() {
        return code;
    }




    @Override
    public String toString() {
        return "ProductInfo{" +
                "code='" + getCode() + '\'' +
                '}';
    }
}
