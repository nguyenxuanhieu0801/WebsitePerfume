package com.nxh.shop.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nxh.shop.domain.User;
import com.nxh.shop.repository.UserRepository;
import com.nxh.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public Optional<User> findByEmail(String email) {
		return Optional.ofNullable(userRepository.findByEmail(email));
	}
	
	@Override
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return null;
		}
		boolean checkPassword = bCryptPasswordEncoder.matches(password, user.getPassword());
		if(!checkPassword) {
			return null;
		}
		return user;
	}
	
	@Override
	public <S extends User> S save(S entity) {
		
		return userRepository.save(entity);
	}
	
	

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		return userRepository.findOne(example);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<Long> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		userRepository.flush();
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}



	@Override
	public <S extends User> long count(Example<S> example) {
		return userRepository.count(example);
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return userRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {
		userRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		userRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public User getById(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return userRepository.findAll(example);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

	
	
}
