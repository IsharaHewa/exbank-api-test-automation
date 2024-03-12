package com.api.service;

import com.api.api.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private List<User> userList;

    public UserService() {

        userList = new ArrayList<>();

        User user1 = new User(1, "user1", 15, "user1@gmail.com", "E_A_00001","ACTIVE","Savings","USD");
        User user2 = new User(2, "user2", 18, "user2@gmail.com", "E_B_00023","ACTIVE","Savings","USD");
        User user3 = new User(3, "user3", 22, "user3@gmail.com", "E_F_00123","DISABLED","Current","USD");
        User user4 = new User(4, "user4", 11, "user4@gmail.com", "E_A_02345","INACTIVE","Savings","USD");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

}
