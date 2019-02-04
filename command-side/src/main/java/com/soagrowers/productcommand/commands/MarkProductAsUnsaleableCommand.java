package com.soagrowers.productcommand.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Sets the ToDoItem to reopened.
 *
 * @author robertgolder
 */
public class MarkProductAsUnsaleableCommand {

    @TargetAggregateIdentifier
    private final Long id;

    /**
     * This constructor must set the Id field, otherwise it's unclear
     * to Axon which aggregate this command is intended for.
     *
     * @param id
     */
    public MarkProductAsUnsaleableCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
