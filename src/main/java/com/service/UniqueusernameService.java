package com.service;

import org.springframework.stereotype.Service;

public interface UniqueusernameService {
    public String checkavailability(String username);
}