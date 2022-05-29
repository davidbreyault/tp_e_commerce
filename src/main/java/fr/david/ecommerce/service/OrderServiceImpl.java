package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.model.OrderProduct;
import fr.david.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orders")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setStatus("En cours");
        orderRepository.save(order);
        return order;
    }

    @Override
    public void update(Order order) throws StockException {
        // Si la commande n'a pas déjà le status 'payée'
        if (!order.getStatus().equals("Payée")) {
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                if (!productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())) {
                    throw new StockException();
                }
            }

            order.setStatus("Payée");

            for (OrderProduct orderProduct : order.getOrderProducts()) {
                productService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
            }
        }
    }
}
