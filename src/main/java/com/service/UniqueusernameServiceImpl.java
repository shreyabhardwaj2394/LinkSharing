package com.service;

import com.dao.UniqueusernameDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shreya on 7/19/2017.
 */
@Service
public class UniqueusernameServiceImpl implements UniqueusernameService {


    UniqueusernameDaoImpl uniqueusernameDao=new UniqueusernameDaoImpl();

    @Override
    public String checkavailability(String username) {
        System.out.println("username::"+username);
        if(uniqueusernameDao.checkavailability(username)){
            return "not available";
        }

        else
            return "available";
    }
}
