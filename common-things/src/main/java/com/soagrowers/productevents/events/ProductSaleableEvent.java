package com.soagrowers.productevents.events;


public class ProductSaleableEvent extends AbstractEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductSaleableEvent() {
    }

    public ProductSaleableEvent(Long id) {
        super(id);
    }
}
