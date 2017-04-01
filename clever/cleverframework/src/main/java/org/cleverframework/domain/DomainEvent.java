package org.cleverframework.domain;

import org.cleverframework.events.Event;

public abstract class  DomainEvent extends Event {

	public DomainEvent(String messageId) {
		super(messageId);
	}  
}
