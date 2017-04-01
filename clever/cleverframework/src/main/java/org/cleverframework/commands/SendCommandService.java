package org.cleverframework.commands;

import org.cleverframework.common.ObjectId;
import org.cleverframework.messages.MessageProducer;

public class SendCommandService {

	private MessageProducer producer;
	
	public CommandSendResult sendAsync(Command command){
		
		return new CommandSendResult();
	}
	
	public CommandHandlerResult send(Command command){

		return new CommandHandlerResult(command.getCommandId(), true);
	}
}
