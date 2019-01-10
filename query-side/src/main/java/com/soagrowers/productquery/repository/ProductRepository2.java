package com.soagrowers.productquery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.soagrowers.productquery.domain.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository2 extends JpaRepository<Product, Long>
{
	public List<Product> findBySaleable(@Param("saleable") boolean saleable);
}
