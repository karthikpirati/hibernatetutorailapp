package com.hibernate.relationships.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subscriber {
	
	@Id
	@GeneratedValue
	@Column(name="sub_id")
	private int subId;
	@Column(name="sub_name",unique=true,nullable = false,length = 20)
	private String name;
	
	@ManyToMany(mappedBy="subscribers",cascade = CascadeType.PERSIST)
	private Set<Channel> channels;
	
	public Subscriber() {
		
	}
	
	public Subscriber(String name) {
		super();
		this.name = name;
		
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
	

	
	
	

}
