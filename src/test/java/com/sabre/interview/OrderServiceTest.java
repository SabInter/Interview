package com.sabre.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    OrderService orderService;

    @BeforeEach
    public void setUp(){
        orderService = new OrderService();
    }

    @Test
    void orderServiceSetsStatusToReservedWhenOrderIsNotFullyPaid(){
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10.12);
        order.setOrderItems(List.of(orderItem));
        OrderStatus reserved = new OrderStatus();
        reserved.setStatusId(1);

        Order result = orderService.reserveAndPayForOrder(order, 9.99);

        assertThat(result.getStatus()).isEqualTo(reserved);
    }

    @Test
    void orderServiceSetsStatusToPaidWhenOrderIsPaid(){
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10.12);
        order.setOrderItems(List.of(orderItem));
        OrderStatus paidOrderStatus = new OrderStatus();
        paidOrderStatus.setStatusId(2);

        Order result = orderService.reserveAndPayForOrder(order, 10.12);

        assertThat(result.getStatus()).isEqualTo(paidOrderStatus);
    }
}
