package com.example.project2.Service;

import com.example.project2.model.MerchantStock;

import java.util.ArrayList;

public class MerchantStockService {
    private ArrayList<MerchantStock> merchantStocksList=new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocksList;
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocksList.add(merchantStock);
    }

    public void updateMerchantStock(int index, MerchantStock merchantStock) {
        merchantStocksList.set(index,merchantStock);
    }

    public void deleteMerchantStock(int index) {
        merchantStocksList.remove(index);
    }
}
