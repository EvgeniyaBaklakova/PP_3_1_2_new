package com.example.pp_3_1_2.service;

import com.example.pp_3_1_2.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(int id);

    void deleteUser(int id);
}
