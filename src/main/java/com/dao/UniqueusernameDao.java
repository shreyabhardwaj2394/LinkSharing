package com.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Shreya on 7/19/2017.
 */

public interface UniqueusernameDao {
    boolean checkavailability(String username);
}
