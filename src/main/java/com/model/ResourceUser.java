package com.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Shreya on 7/18/2017.
 */
@Embeddable
public class ResourceUser{

    private Resource resource;
    private User user;

    public ResourceUser() {
        super();
    }

    public ResourceUser(Resource resource, User user) {
        super();
        this.resource = resource;
        this.user = user;
    }

    @ManyToOne
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}