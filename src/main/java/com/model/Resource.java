package com.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
@Entity
public class Resource {
    private Integer resourceId;
    private String description;
    private User createdBy;
    private Topic topic;
    private Date dateCreated;
    private Date lastUpdated;

    public Resource() {
    }

    public Resource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated) {

        this.description = description;
        this.createdBy = createdBy;
        this.topic = topic;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "resource_id")
    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(targetEntity = User.class)
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @ManyToOne(targetEntity = Topic.class)
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "last_updated")
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Resource : " + topic + " " + description;
    }
}
