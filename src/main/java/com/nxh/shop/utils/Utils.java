package com.nxh.shop.utils;

import java.util.HashMap;
import java.util.Map;

import com.nxh.shop.domain.CartItem;

public class Utils {
	public static int countCart(Map<Long, CartItem> cart) {
		int q = 0;
		
		if(cart != null) {
			for(CartItem c : cart.values()) {
				q += c.getQuantity();
			}
		}
		
		return q;
	}
	
	public static Long sumAmount(Map<Long, CartItem> cart) {
		Long s = 0l;
		
		if(cart != null) {
			for(CartItem c : cart.values()) {
				s +=  (long) (c.getQuantity() * c.getPrice()); 
			}
		}
		
		return s;
	}
}
