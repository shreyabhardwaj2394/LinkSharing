package com.service;

import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shreya on 7/18/2017.
 */
@Service
public class TopicServiceImpl {

    @Autowired
    TopicDaoImpl topicDao;

    public int saveTopic(Topic topic, User user){
        int  topicId=topicDao.saveTopic(topic,user);

        System.out.println("topic id"+topicId);
        return topicId;
    }

    public Topic getTopic(Integer topicId){
        Topic topic=topicDao.getTopicById(topicId);
        return topic;
    }
}
