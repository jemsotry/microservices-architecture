package com.soagrowers.productcommand.commands;

/**
 * Created by ben on 19/01/16.
 */
public class WebCreateTodoCommand {

    private final Long id;
    private final String description;

    public WebCreateTodoCommand(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
