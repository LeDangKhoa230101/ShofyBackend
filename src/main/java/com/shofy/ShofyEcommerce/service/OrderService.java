package com.shofy.ShofyEcommerce.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.OrderDto;
import com.shofy.ShofyEcommerce.dto.cart.CartItemDto;
import com.shofy.ShofyEcommerce.entity.Order;
import com.shofy.ShofyEcommerce.entity.OrderItem;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.repository.OrderItemRepository;
import com.shofy.ShofyEcommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderDto checkout(String phone, String address, String note, User user) {
		// Lấy thông tin đơn hàng từ giỏ hàng
        OrderDto orderDto = cartService.createOrder(user);
		
        // Tạo đơn hàng mới từ thông tin trong orderDto và các thông tin mới
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setPhone(phone);
        order.setAddress(address);
        order.setNote(note);
        order.setCreatedDate(new Date());
        
        orderRepository.save(order);
        
        //Lưu các mục đơn hàng vào cơ sở dữ liệu
        for(CartItemDto cartItem : orderDto.getCartItems()) {
        	OrderItem orderItem = new OrderItem();
        	orderItem.setOrder(order);
        	orderItem.setQuanty(cartItem.getQuanty());
        	orderItem.setPrice(cartItem.getProductPriceNew());
        	orderItem.setCreatedDate(new Date());
        	orderItemRepository.save(orderItem);
        }
        
        cartService.clearCart(user);
        
		return orderDto;
	}
	
}
