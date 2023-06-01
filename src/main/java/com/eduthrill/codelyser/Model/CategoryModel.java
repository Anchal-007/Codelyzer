package com.eduthrill.codelyser.Model;

import com.eduthrill.codelyser.Entity.Quiz;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CategoryModel {
    long category_id;
    String description;
    String title;
    private Set<Quiz> quizzes=new LinkedHashSet<>();
}
