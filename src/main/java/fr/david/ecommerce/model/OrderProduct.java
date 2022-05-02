package fr.david.ecommerce.model;

public class OrderProduct {

    private Product product;
    private Order order;
    private int quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Product product, Order order, int quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
