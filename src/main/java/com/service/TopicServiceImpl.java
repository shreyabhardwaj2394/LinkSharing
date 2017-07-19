package com.service;

import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shreya on 7/18/2017.
 */
@Service
public class TopicServiceImpl {

    TopicDaoImpl topicDao=new TopicDaoImpl();

    public int saveTopic(Topic topic, User user){
        int  topicId=topicDao.saveTopic(topic,user);

        System.out.println("topic id"+topicId);
        return topicId;
    }

    public Topic getTopic(Integer topicId){
        Topic topic=topicDao.getTopicById(topicId);
        return topic;
    }

    public Map subscriptionAndTopicCount(HttpServletRequest request){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("TopicCount",topicDao.topicCount(request));
        return map;
    }
}
