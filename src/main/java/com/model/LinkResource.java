package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "link_resource")
public class LinkResource extends Resource {

	private String url;

	public LinkResource() {
		super();
	}

	public LinkResource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated,
			String url) {
		super(description, createdBy, topic, dateCreated, lastUpdated);
		this.url = url;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LinkResource [url=" + url + "]";
	}

}
