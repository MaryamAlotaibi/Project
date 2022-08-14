package com.example.project2.controller;

import com.example.project2.Service.CategoryService;
import com.example.project2.model.ApiResponse;
import com.example.project2.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categorysevice) {
        this.categoryService = categoryService;
    }
    @GetMapping("/category1")
    public ResponseEntity getCategory(){
        ArrayList<Category> categoryServiceCategory=categoryService.getCategory();
        return ResponseEntity.status(200).body(categoryServiceCategory);
    }

    @PostMapping ("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.addCategory(categoryService);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }
    //
    @PutMapping("/category/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid CategoryService categoryService
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.updateCategory(index,categoryService);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/category/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index){
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }

}
