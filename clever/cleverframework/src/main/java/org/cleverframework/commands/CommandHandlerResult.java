package org.cleverframework.commands;

public class CommandHandlerResult {

    private String identityId;

    private Boolean succeed;

    private String message;

    public CommandHandlerResult(String identityId, Boolean succeed) {
        this.identityId = identityId;
        this.succeed = succeed;
    }

    public CommandHandlerResult(String identityId, Boolean succeed, String message) {
        this(identityId, succeed);

        this.message = message;
    }
}
