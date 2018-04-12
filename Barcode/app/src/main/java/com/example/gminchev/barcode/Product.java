package com.example.gminchev.barcode;

/**
 * Created by GMinchev on 12.4.2018 г..
 */

public class Product {
    String code;
    String product_name;
    String ingredients_text;

    public String getCode() {
        return code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getIngredients_text() {
        return ingredients_text;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setIngredients_text(String ingredients_text) {
        this.ingredients_text = ingredients_text;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                '}';
    }
}
