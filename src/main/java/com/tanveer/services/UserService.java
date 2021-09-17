package com.tanveer.services;

import com.tanveer.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
List<UserModel> userModels =new ArrayList<>();
List<String> homeTowns=new ArrayList<>(Arrays.asList("Dhaka","Khulna","Sylhet"));

    public List<UserModel> getUsers() {
        return userModels;
    }

    public List<String> getHomeTowns() {
        return homeTowns;
    }

    public void saveUser(UserModel userModel) {
        this.userModels.add(userModel);
    }
}
