package com.model;

import com.model.Topic;
import com.model.User;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;



@Embeddable
public class TopicUser {


    private Topic topic;
    private User user;

    public TopicUser() {
        super();
    }

    public TopicUser(Topic topic, User user) {

        this.topic = topic;
        this.user = user;
    }

    @ManyToOne
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
