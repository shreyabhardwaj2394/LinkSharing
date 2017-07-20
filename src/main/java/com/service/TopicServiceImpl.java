package com.service;

import com.dao.TopicDaoImpl;
import com.model.Topic;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
        System.out.println("getting topic");
        Topic topic=topicDao.getTopicById(topicId);
        return topic;
    }

    public Map TopicCount(HttpServletRequest request){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("TopicCount",topicDao.topicCount(request));
        return map;
    }

    public List getSubscribedTopics(User user){
        List<Topic> list=topicDao.getSubscribedTopics(user);
        return list;
    }

    public Map getPublicTopics(){
        Map<Topic,User> map=new HashMap<Topic, User>();
        List<Topic> list=topicDao.getPublicTopics();
       for(Topic topic:list){
          User user=topic.getCreatedBy();
           map.put(topic,user);
       }
        return map;
    }
}


