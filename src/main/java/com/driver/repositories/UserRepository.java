package com.driver.repositories;

import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

    HashMap<Integer, User> UserDb = new HashMap<>();

    public int addUser(User user) {

        UserDb.put(user.getaadharCardNo(),user);
        return user.getaadharCardNo();

    }
}
