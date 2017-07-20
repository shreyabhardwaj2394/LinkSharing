package com.service;

import com.dao.SubscriptionDaoImpl;
import com.dao.TopicDaoImpl;
import com.model.Subscription;
import com.model.Topic;
import com.model.User;

import com.utils.enums.Seriousness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Shreya on 7/18/2017.
 */
@Service
public class SubscriptionServiceImpl {


   SubscriptionDaoImpl subscriptionDao=new SubscriptionDaoImpl();

    TopicDaoImpl topicDao=new TopicDaoImpl();

    public boolean saveSubscription(int topicId, User user, Seriousness seriousness){
        boolean status=false;
        Topic topic=topicDao.getTopicById(topicId);
        status=subscriptionDao.saveSubscription(topic,user,seriousness);
        return status;
    }

    public Map subscriptionCount(HttpServletRequest request){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("SubscriptionCount",subscriptionDao.subscriptionCount(request));
        return map;
    }

    public List getSubscriptionList(HttpServletRequest request){
        List<Subscription> subscriptionList=subscriptionDao.getSubscriptionList(request);
        return subscriptionList;
    }
}
