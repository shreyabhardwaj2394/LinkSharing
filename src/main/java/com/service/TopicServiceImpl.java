package com.service;

import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;

/**
 * Created by Shreya on 7/18/2017.
 */
public class TopicServiceImpl {

    TopicDaoImpl topicDao=new TopicDaoImpl();
    public int saveTopic(Topic topic, User user){
        int  topicId=topicDao.saveTopic(topic,user);

        System.out.println("topic id"+topicId);
        return topicId;
    }

    public Topic getTopic(Topic t){
        Integer topicId=t.getTopicId();
        Topic topic=topicDao.getTopicById(topicId);
        return topic;
    }
}
