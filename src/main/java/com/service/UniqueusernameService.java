package com.service;

import org.springframework.stereotype.Service;

public interface UniqueusernameService {
    String checkavailability(String username);
}