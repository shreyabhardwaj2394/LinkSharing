package com.service;

import com.dao.TopicDaoImpl;
import com.model.Subscription;
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

    public Topic getTopicByName(String topicName){
        System.out.println("getting topic");
        Topic topic=topicDao.getTopicByName(topicName);
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

    public List getTopicsList(HttpServletRequest request){
        List<Topic> list=topicDao.getCreatedTopicsList(request);
        return list;
    }

    public List getPublicTopics(){
        List<Topic> list=topicDao.getPublicTopics();
        return list;
    }
    public List getCreatedTopicList(HttpServletRequest request){
        List<Topic> topicList=topicDao.getCreatedTopicsList(request);
        return topicList;
    }


    public boolean deleteTopicAndResource(HttpServletRequest request,Integer topicId) {
        boolean status=false;
        status=topicDao.deleteTopicAndResource(request,topicId);
        return status;
    }

    public boolean editTopic( Integer topicId,String topicName) {
        boolean status=false;
        status=topicDao.editTopic(topicId,topicName);
        return status;
    }

    public List<Topic> getTopicList(String topicName) {
        List<Topic> list=topicDao.getTopicList(topicName);
        return list;
    }
}


