package com.soagrowers.productevents.events;


public class ProductAddedEvent extends AbstractEvent {


    /**
	 * 
	 */
	private static final long serialVersionUID = -6542506577483045829L;
	
	private String name;

    public ProductAddedEvent() {
    }

    public ProductAddedEvent(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
