package fr.david.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "table_order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    private int quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(OrderProductId id, Product product, Order order, int quantity) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    // Note : ne pas faire de getter sur order pour éviter le problème de récursion infinie (order -> orderproduct -> order -> orderproduct...)

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
