package com.sabre.interview;

class OrderItem {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.round(price * 100) / 100.0;
    }

}
