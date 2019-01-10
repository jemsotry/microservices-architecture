package com.soagrowers.productquery.handlers;

import java.math.BigDecimal;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soagrowers.productevents.events.ProductAddedEvent;
import com.soagrowers.productevents.events.ProductSaleableEvent;
import com.soagrowers.productevents.events.ProductUnsaleableEvent;
import com.soagrowers.productquery.domain.Product;
import com.soagrowers.productquery.repository.ProductRepository2;

/**
 * Created by Ben on 10/08/2015.
 */
@Component
public class ProductViewEventHandler implements ReplayAware {

    private static final Logger LOG = LoggerFactory.getLogger(ProductViewEventHandler.class);

    @Autowired
    private ProductRepository2 productRepository;

    @EventHandler
    public void handle(ProductAddedEvent event) {
        LOG.info("ProductAddedEvent to DB MySQL: [{}] '{}'", event.getId(), event.getName());
        productRepository.save(new Product(new Long(event.getId()), event.getName(), BigDecimal.ZERO, "AUTOMATIC DESCRIPTION", false));
    }

    @EventHandler
    public void handle(ProductSaleableEvent event) {
        LOG.info("ProductSaleableEvent: [{}]", event.getId());
        if (productRepository.findOne(new Long(event.getId())) != null) {
        //if (productRepository.exists(event.getId())) {
            Product product = productRepository.findOne(new Long(event.getId()));
            if (!product.isSaleable()) {
                product.setSaleable(true);
                productRepository.save(product);
            }
        }
    }

    @EventHandler
    public void handle(ProductUnsaleableEvent event) {
        LOG.info("ProductUnsaleableEvent: [{}]", event.getId());
        if (productRepository.findOne(new Long(event.getId())) != null) {
        //if (productRepository.exists(event.getId())) {
            Product product = productRepository.findOne(new Long(event.getId()));
            if (product.isSaleable()) {
                product.setSaleable(false);
                productRepository.save(product);
            }
        }
    }

    public void beforeReplay() {
        LOG.info("Event Replay is about to START. Clearing the View...");
    }

    public void afterReplay() {
        LOG.info("Event Replay has FINISHED.");
    }

    public void onReplayFailed(Throwable cause) {
        LOG.error("Event Replay has FAILED.");
    }
}
