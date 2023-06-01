package com.eduthrill.codelyser.Model;

import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Entity.User;
import lombok.Data;

@Data
public class ResultModel {
    private int result_id;

    private Quiz quiz;

    private User user;

    private int questions_attempted;

    private int correct_answers;

    private double marks_scored;

    private String submit_date_time;
}
