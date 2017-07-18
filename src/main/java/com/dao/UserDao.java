package com.dao;

import com.model.User;

/**
 * Created by Shreya on 7/11/2017.
 */
public interface UserDao {
    int register(User user,byte[] photo);
    void update(User user);
    void delete(User user);
    User findUser(String username);
}
