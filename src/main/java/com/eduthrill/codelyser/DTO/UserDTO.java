package com.eduthrill.codelyser.DTO;

import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Model.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTO {
    public User modelToEntity(UserModel userModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        User userEntity = mapper.map(userModel, User.class);
        return userEntity;
    }

    public UserModel entityToModel( User userEntity){
        ModelMapper mapper =new ModelMapper();
        UserModel userModel = mapper.map(userEntity, UserModel.class);
        return userModel;
    }

    public List<UserModel> allEntitiesToModels (List<User> userEntities){
        return userEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }
}
