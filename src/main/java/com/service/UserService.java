package com.service;

import com.model.User;

/**
 * Created by Shreya on 7/18/2017.
 */
interface UserService {
    void register(User user);
    boolean login(User user);
}
