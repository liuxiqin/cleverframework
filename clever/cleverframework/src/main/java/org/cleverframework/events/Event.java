package org.cleverframework.events;

import org.cleverframework.messages.Message;

public abstract class Event extends Message {

	private String eventId;

	public Event(String messageId) {
		super(messageId);		
        this.eventId=messageId;
	}

	private int version;
	
	public String getEventId(){
		return this.eventId;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return this.version;
	}

}
