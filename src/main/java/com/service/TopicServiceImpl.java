package com.service;

import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;

/**
 * Created by Shreya on 7/18/2017.
 */
public class TopicServiceImpl {

    TopicDaoImpl topicDao=new TopicDaoImpl();
    public boolean saveTopic(Topic topic, String user){
        boolean status=topicDao.saveTopic(topic,user);

        System.out.println("status"+status);
        if(status==true)
            return true;
        else
            return false;
    }
}
