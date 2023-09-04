package com.driver.services;

import com.driver.model.User;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    UserRepository userRepository =  new UserRepository();

    public int addUser(User user) {
       int ans = userRepository.addUser(user);

       return ans;
    }
}
