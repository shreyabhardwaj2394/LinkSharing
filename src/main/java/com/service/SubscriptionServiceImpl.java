package com.service;

import com.dao.SubscriptionDaoImpl;
import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;

import com.utils.enums.Seriousness;


/**
 * Created by Shreya on 7/18/2017.
 */
public class SubscriptionServiceImpl {

   SubscriptionDaoImpl subscriptionDao=new SubscriptionDaoImpl();

    TopicDaoImpl topicDao=new TopicDaoImpl();

    public boolean saveSubscription(int topicId, User user, Seriousness seriousness){
        boolean status=false;
        Topic topic=topicDao.getTopicById(topicId);
        status=subscriptionDao.saveSubscription(topic,user,seriousness);
        return status;
    }
}