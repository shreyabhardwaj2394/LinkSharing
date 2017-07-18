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
@Table(name = "reading_item")
@AssociationOverrides({ @AssociationOverride(name = "resourceUser.user", joinColumns = @JoinColumn(name = "user_id") ),
		@AssociationOverride(name = "resourceUser.resource", joinColumns = @JoinColumn(name = "resource_id") ) })
public class ReadingItem  {


	private Integer readingItemId;
	private ResourceUser resourceUser = new ResourceUser();
	private Boolean isRead;

	public ReadingItem() {

	}

	public ReadingItem(ResourceUser resourceUser, Boolean isRead) {

		this.resourceUser = resourceUser;
		this.isRead = isRead;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reading_item_id")
	public Integer getReadingItemId() {
		return readingItemId;
	}

	public void setReadingItemId(Integer readingItemId) {
		this.readingItemId = readingItemId;
	}

	@EmbeddedId
	public ResourceUser getResourceUser() {
		return resourceUser;
	}

	public void setResourceUser(ResourceUser resourceUser) {
		this.resourceUser = resourceUser;
	}

	@Transient
	public Resource getResource() {
		return resourceUser.getResource();
	}

	public void setResource(Resource resource) {
		resourceUser.setResource(resource);
	}

	@Transient
	public User getUser() {
		return resourceUser.getUser();
	}

	public void setUser(User user) {
		resourceUser.setUser(user);
	}

	@Column(name = "is_read")
	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "ReadingItem [resourceUser=" + resourceUser + ", isRead=" + isRead + "]";
	}

}
