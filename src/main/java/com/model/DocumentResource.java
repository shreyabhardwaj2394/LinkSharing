package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "document_resource")
public class DocumentResource extends Resource {

	private String filePath;

	public DocumentResource() {
		super();
	}

	public DocumentResource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated,
			String filePath) {
		super(description, createdBy, topic, dateCreated, lastUpdated);
		this.filePath = filePath;
	}

	@Column(name = "file_path")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "DocumentResource [filePath=" + filePath + "]";
	}

}
