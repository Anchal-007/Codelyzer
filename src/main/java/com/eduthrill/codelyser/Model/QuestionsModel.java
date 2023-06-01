package com.eduthrill.codelyser.Model;

import com.eduthrill.codelyser.Entity.Quiz;
import lombok.Data;


@Data
public class QuestionsModel {
    private long question_id;
    private String question;
    private String answer;
    private Quiz quiz;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String option_5;
    private String option_6;
    private String option_7;
    private String option_8;
    private String option_9;
    private String option_10;
    private String level;
}
