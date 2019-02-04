package com.soagrowers.productevents.events;

import java.io.Serializable;

public abstract class AbstractEvent implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

    public AbstractEvent() {}

    public AbstractEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
