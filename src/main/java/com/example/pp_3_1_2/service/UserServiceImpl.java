package com.example.pp_3_1_2.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.pp_3_1_2.dao.UserDao;
import com.example.pp_3_1_2.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
