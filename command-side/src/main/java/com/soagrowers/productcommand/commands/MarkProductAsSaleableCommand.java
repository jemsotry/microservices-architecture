package com.soagrowers.productcommand.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by Ben on 07/08/2015.
 */
public class MarkProductAsSaleableCommand {

    /**
     * How does Axon know which Aggregate to Mark as completed? It uses
     * the TargetAggregateIdentifier annotation so that it can get the
     * correct one based on the Id in the annotated field.
     */
    @TargetAggregateIdentifier
    private final Long id;

    /**
     * This constructor must set the Id field, otherwise it's unclear
     * to Axon which aggregate this command is intended for.
     *
     * @param id
     */
    public MarkProductAsSaleableCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
