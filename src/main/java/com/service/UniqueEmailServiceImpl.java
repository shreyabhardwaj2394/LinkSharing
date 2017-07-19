package com.service;

import com.dao.UniqueEmailDao;
import com.dao.UniqueEmailDaoImpl;
import com.dao.UniqueusernameDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shreya on 7/19/2017.
 */
@Service
public class UniqueEmailServiceImpl implements UniqueEmailService {

    UniqueEmailDaoImpl uniqueEmailDao=new UniqueEmailDaoImpl();

    @Override
    public String checkavailability(String email) {
        System.out.println("Email::"+email);
        if(uniqueEmailDao.checkavailability(email)){
            return "not available";
        }

        else
            return "available";
    }
}
