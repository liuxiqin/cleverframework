package org.cleverframework.commands;

public class CommandSendResult {
	
	private Boolean succeed;

	private String message;

	public CommandSendResult() {
		succeed = true;
	}

	public CommandSendResult(String message) {
		this();
		this.message = message;
	}

	public Boolean getSucceed() {
		return this.succeed;
	}

	public String getMessage() {
		return this.message;
	}
}
