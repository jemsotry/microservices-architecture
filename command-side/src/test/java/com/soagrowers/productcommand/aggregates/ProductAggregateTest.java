package com.soagrowers.productcommand.aggregates;

import com.soagrowers.productcommand.commands.AddProductCommand;
import com.soagrowers.productcommand.commands.MarkProductAsSaleableCommand;
import com.soagrowers.productcommand.commands.MarkProductAsUnsaleableCommand;
import com.soagrowers.productevents.events.AbstractEvent;
import com.soagrowers.productevents.events.ProductAddedEvent;
import com.soagrowers.productevents.events.ProductSaleableEvent;
import com.soagrowers.productevents.events.ProductUnsaleableEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 07/08/2015.
 */
public class ProductAggregateTest {

    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(ProductAggregate.class);
    }

    @Test
    public void testAddProduct() throws Exception {
        fixture.given()
                .when(new AddProductCommand(new Long(1), "product name"))
                .expectEvents(new ProductAddedEvent(new Long(1), "product name"));
    }

    @Test
    public void testMarkProductItemAsSaleable() throws Exception {
        fixture.given(new ProductAddedEvent(new Long(2), "product name"))
                .when(new MarkProductAsSaleableCommand(new Long(2)))
                .expectVoidReturnType()
                .expectEvents(new ProductSaleableEvent(new Long(2)));
    }

    @Test
    public void testMarkProductItemAsUnsaleableIsAllowed() throws Exception {
        List<AbstractEvent> events = new ArrayList<AbstractEvent>();
        events.add(new ProductAddedEvent(new Long(3), "product name"));
        events.add(new ProductSaleableEvent(new Long(3)));

        fixture.given(events)
                .when(new MarkProductAsUnsaleableCommand(new Long(3)))
                .expectVoidReturnType()
                .expectEvents(new ProductUnsaleableEvent(new Long(3)));
    }

    @Test
    public void testMarkProductItemAsUnsaleableIsPrevented() throws Exception {
        List<AbstractEvent> events = new ArrayList<AbstractEvent>();
        events.add(new ProductAddedEvent(new Long(3), "product name"));

        fixture.given(events)
                .when(new MarkProductAsUnsaleableCommand(new Long(3)))
                .expectException(IllegalStateException.class);
    }
}
