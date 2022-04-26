package com.nxh.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	public Page<Order> findByUser(User user, Pageable pageable);
}
