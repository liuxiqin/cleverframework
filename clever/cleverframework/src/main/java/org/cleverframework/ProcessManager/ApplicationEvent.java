package org.cleverframework.ProcessManager;

import org.cleverframework.events.Event;

public abstract class ApplicationEvent extends Event {

	private String eventId;
	
	public ApplicationEvent(String eventId) {
		super(eventId);	 
		
		this. eventId=eventId;
	}

	public String getEventId(){
		return eventId;
	}
}
