package com.eduthrill.codelyser.Model;

import com.eduthrill.codelyser.Entity.Result;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserModel {
    long user_id;

    String first_name;

    String last_name;

    String phone_no;

    String email_id;

    String username;

    boolean enabled;

    String password;

    String role_name;

    private List<Result> results=new ArrayList<>();

}
