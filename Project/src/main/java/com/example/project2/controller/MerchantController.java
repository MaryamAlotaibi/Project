package com.example.project2.controller;

import com.example.project2.Service.CategoryService;
import com.example.project2.Service.MerchantService;
import com.example.project2.model.ApiResponse;
import com.example.project2.model.Category;
import com.example.project2.model.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }
    @GetMapping("/merchant1")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchantServicemerchant=merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchantServicemerchant);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchantService);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }
    //
    @PutMapping("/merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid MerchantService merchantService
            , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.updateMerchant(index,merchantService);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/merchant/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }
}
