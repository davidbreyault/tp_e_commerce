package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;
}
