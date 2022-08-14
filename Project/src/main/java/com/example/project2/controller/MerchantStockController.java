package com.example.project2.controller;

import com.example.project2.Service.MerchantService;
import com.example.project2.Service.MerchantStockService;
import com.example.project2.model.ApiResponse;
import com.example.project2.model.MerchantStock;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock")
public class MerchantStockController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    public MerchantStockController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/merchantstock1")
    public ResponseEntity getMerchants(){
        ArrayList<MerchantStock> merchantStocks= MerchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestParam @Valid MerchantStock merchantstock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        MerchantStockService.addMerchantStock(merchantstock);
        return ResponseEntity.status(201).body( new ApiResponse("New Merchant added !",201));
    }
    @PutMapping("/merchantstock/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStockService merchantstockService
            , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantstockService.updateMerchantStock(index,merchantstockService);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/merchantstock/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable int index){
        MerchantStockController merchantstockService;
        merchantstockService.deleteMerchantStock(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }
}
