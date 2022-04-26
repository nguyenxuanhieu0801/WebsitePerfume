package com.nxh.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.User;

public interface OrderService {

	<S extends Order> List<S> findAll(Example<S> example, Sort sort);

	<S extends Order> List<S> findAll(Example<S> example);

	Order getById(Long id);

	void deleteAll();

	void deleteAllInBatch();

	void delete(Order entity);

	void deleteById(Long id);

	long count();

	<S extends Order> boolean exists(Example<S> example);

	<S extends Order> long count(Example<S> example);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(Long id);

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> saveAll(Iterable<S> entities);

	Optional<Order> findById(Long id);

	List<Order> findAllById(Iterable<Long> ids);

	List<Order> findAll(Sort sort);

	List<Order> findAll();

	Page<Order> findAll(Pageable pageable);

	<S extends Order> Optional<S> findOne(Example<S> example);

	<S extends Order> S save(S entity);
	
	public Page<Order> getOrderInUser(int pageNo, int pageSize, String sortField,String sortDirection,User user);


}
