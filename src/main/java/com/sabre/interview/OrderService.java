package com.sabre.interview;

public class OrderService {
    Order reserveAndPayForOrder(Order order, double paidPrice) {

        OrderStatus reservedOrder = new OrderStatus();
        reservedOrder.setStatusId(1);
        order.setStatus(reservedOrder);


        double totalPrice = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            double tmpPrice = order.getOrderItems().get(i).getPrice();
            totalPrice += tmpPrice;
        }

        if (paidPrice >= totalPrice) {
            OrderStatus paidOrder = new OrderStatus();
            paidOrder.setStatusId(2);
            order.setStatus(paidOrder);
        }

        return order;
    }
}
