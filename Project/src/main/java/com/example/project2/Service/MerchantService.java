package com.example.project2.Service;

import com.example.project2.model.Merchant;

import java.util.ArrayList;

public class MerchantService {
    private ArrayList<Merchant> merchantList=new ArrayList<>();

    public ArrayList<Merchant> getMerchant() {
        return merchantList;
    }

    public void addMerchant(Merchant merchant) {
        merchantList.add(merchant);
    }

    public void updateMerchant(int index, Merchant merchant) {
        merchantList.set(index,merchant);
    }

    public void deleteMerchant(int index) {
        merchantList.remove(index);
    }
}
