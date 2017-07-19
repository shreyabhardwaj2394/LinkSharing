package com.service;

import com.dao.SubscriptionDaoImpl;
import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;

import com.utils.enums.Seriousness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Shreya on 7/18/2017.
 */
@Service
public class SubscriptionServiceImpl {

    @Autowired
   SubscriptionDaoImpl subscriptionDao;
    @Autowired
    TopicDaoImpl topicDao;

    public boolean saveSubscription(int topicId, User user, Seriousness seriousness){
        boolean status=false;
        Topic topic=topicDao.getTopicById(topicId);
        status=subscriptionDao.saveSubscription(topic,user,seriousness);
        return status;
    }
}
