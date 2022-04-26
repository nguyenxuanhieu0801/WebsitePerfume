package com.nxh.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nxh.shop.domain.OrderDetail;
import com.nxh.shop.repository.OrderDetailRepository;
import com.nxh.shop.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return orderDetailRepository.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return orderDetailRepository.findOne(example);
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailRepository.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRepository.findAll();
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return orderDetailRepository.findAll(sort);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return orderDetailRepository.findById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return orderDetailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		orderDetailRepository.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return orderDetailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return orderDetailRepository.existsById(id);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailRepository.findAll(example, pageable);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return orderDetailRepository.count(example);
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return orderDetailRepository.exists(example);
	}

	@Override
	public long count() {
		return orderDetailRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		orderDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll() {
		orderDetailRepository.deleteAll();
	}

	@Override
	public OrderDetail getById(Long id) {
		return orderDetailRepository.getById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return orderDetailRepository.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailRepository.findAll(example, sort);
	}
	
	
}
