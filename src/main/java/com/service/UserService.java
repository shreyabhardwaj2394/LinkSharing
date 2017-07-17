package com.service;

import com.model.User;

/**
 * Created by Shreya on 7/18/2017.
 */
interface UserService {
    public void register(User user);
    public boolean login(User user);
}
