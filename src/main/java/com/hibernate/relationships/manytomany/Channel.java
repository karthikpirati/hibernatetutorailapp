package com.hibernate.relationships.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/*
 * The entity that specifies the @JoinTable is the owning side of the relationship 
 * and the entity that specifies the mappedBy attribute is the inverse side.
 * Channel is owning side of the relationship 
 * Subscriber is inverse side.
 */
@Entity
public class Channel {
	
	

	@Id
	@GeneratedValue
	@Column(name="channel_id")
	private int channelId;
	@Column(name="channel_name",nullable = false,unique = true,length=20)
	private String channelName;
	
	/*
	 * Channel is the owner
	 * so pass channel_id to join columns
	 * sub_id to inverseJoinColumns
	 */
	@ManyToMany()
	@JoinTable(
			name="channel_subscriber",
			joinColumns = {@JoinColumn(name="channel_id")},
			inverseJoinColumns={@JoinColumn(name="sub_id")}
			)
	private Set<Subscriber> subscribers;
	
	public Channel() {
		
	}

	public Channel(String channelName) {
		super();
		this.channelName = channelName;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	
	
	public Set<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + "]";
	}
	
	
}
