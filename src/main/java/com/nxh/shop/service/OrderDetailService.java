package com.nxh.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nxh.shop.domain.OrderDetail;

public interface OrderDetailService {

	<S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends OrderDetail> List<S> findAll(Example<S> example);

	OrderDetail getById(Long id);

	void deleteAll();

	void deleteAllInBatch();

	void delete(OrderDetail entity);

	void deleteById(Long id);

	long count();

	<S extends OrderDetail> boolean exists(Example<S> example);

	<S extends OrderDetail> long count(Example<S> example);

	<S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(Long id);

	<S extends OrderDetail> S saveAndFlush(S entity);

	void flush();

	<S extends OrderDetail> List<S> saveAll(Iterable<S> entities);

	Optional<OrderDetail> findById(Long id);

	List<OrderDetail> findAll(Sort sort);

	List<OrderDetail> findAll();

	Page<OrderDetail> findAll(Pageable pageable);

	<S extends OrderDetail> Optional<S> findOne(Example<S> example);

	<S extends OrderDetail> S save(S entity);

}
