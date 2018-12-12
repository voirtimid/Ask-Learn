package com.example.asklearn.Models.Comparators;

import com.example.asklearn.Models.Category;

import java.util.Comparator;

public class CategoryNameComparator implements Comparator<Category> {
    @Override
    public int compare(Category category, Category otherCategory) {
        return category.getName().compareToIgnoreCase(otherCategory.getName());
    }
}
