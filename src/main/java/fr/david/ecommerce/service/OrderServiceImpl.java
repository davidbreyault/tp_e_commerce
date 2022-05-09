package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Order;
import fr.david.ecommerce.model.OrderProduct;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private ProductService productService;
    private List<Order> allOrders = new ArrayList<>();

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order create(Order order) {
        order.setStatus("En cours");
        allOrders.add(order);
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
