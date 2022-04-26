package com.nxh.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nxh.shop.domain.Category;
import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.Product;
import com.nxh.shop.domain.User;

public interface ProductService {

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	Product getById(Long id);

	void deleteAll();

	void deleteAllInBatch();

	void delete(Product entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	<S extends Product> boolean exists(Example<S> example);

	<S extends Product> long count(Example<S> example);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(Long id);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	Optional<Product> findById(Long id);

	List<Product> findAll(Sort sort);

	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);

	List<Product> getTop10NewProduct();
	
	public Page<Product> getProductInCategory(int pageNo, int pageSize, String sortField,String sortDirection,Category category);


}
