package com.example.project2.Service;

import com.example.project2.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private ArrayList<Category> categoryList=new ArrayList<>();

    public ArrayList<Category> getCategory() {
        return categoryList;

    }

    public void addProduct(Category category) {
        categoryList.add(category);
    }

    public void updateCategory(int index, Category category) {
        categoryList.set(index,category);
    }

    public void deleteCategory(int index) {
        categoryList.remove(index);
    }

    public void addCategory(CategoryService categoryService) {
    }
}

