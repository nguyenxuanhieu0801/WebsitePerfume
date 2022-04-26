package com.nxh.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nxh.shop.domain.Category;
import com.nxh.shop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value="SELECT TOP 10 * FROM products  ORDER BY product_id DESC",nativeQuery = true)
	public List<Product> getTop10NewProduct();
	
	public Page<Product> findByCategory(Category category, Pageable pageable);
}
