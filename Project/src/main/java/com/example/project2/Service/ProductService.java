package com.example.project2.Service;

import com.example.project2.model.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ProductService {
    private ArrayList<Product> productsList=new ArrayList<>();

    public  void updateProduct(int index, Product product) {
        productsList.set(index,product);
    }

    public  ArrayList<Product> getProducts() {
        return productsList;
    }

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public void deleteProduct(int index) {
        productsList.remove(index);
    }

    public double getPriceByID(String id){
        for (int i = 0; i <productsList.size() ; i++) {
            if (!Objects.equals(productsList.get(i).getID(), id)) {
                continue;
            }
            return productsList.get(i).getPrice();
        }
        return -1;
    }

}
