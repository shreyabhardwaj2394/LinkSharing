package com.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "resource_rating")
@AssociationOverrides({ @AssociationOverride(name = "resourceUser.user", joinColumns = @JoinColumn(name = "user_id") ),
		@AssociationOverride(name = "resourceUser.resource", joinColumns = @JoinColumn(name = "resource_id") ) })
public class ResourceRating {


	private Integer resourceRatingId;
	private ResourceUser resourceUser = new ResourceUser();
	private Integer score;

	public ResourceRating() {

	}

	public ResourceRating(ResourceUser resourceUser, Integer score) {

		this.resourceUser = resourceUser;
		this.score = score;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resource_rating_id")
	public Integer getResourceRatingId() {
		return resourceRatingId;
	}

	public void setResourceRatingId(Integer resourceRatingId) {
		this.resourceRatingId = resourceRatingId;
	}

	@EmbeddedId
	public ResourceUser getResourceUser() {
		return resourceUser;
	}

	public void setResourceUser(ResourceUser resourceUser) {
		this.resourceUser = resourceUser;
	}
	
	@Transient
	public User getUser() {
		return resourceUser.getUser();
	}
	
	public void setUser(User user) {
		resourceUser.setUser(user);
	}
	
	@Transient
	public Resource getResource() {
		return resourceUser.getResource();
	}
	
	public void setResource(Resource resource) {
		resourceUser.getResource();
	}

	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ResourceRating [resourceUser=" + resourceUser + ", score=" + score + "]";
	}

}
