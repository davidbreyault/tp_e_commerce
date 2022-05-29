package fr.david.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "table_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate dateCreated;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private List<OrderProduct> orderProducts;

    public Order() {
        super();
    }

    public Order(Long id, LocalDate dateCreated, String status, Client client, List<OrderProduct> orderProducts) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public int getNumberOfProducts() {
        return getOrderProducts().size();
    }

    public int getTotalNumberOfProducts() {
        int sumTotalProduct = 0;
        for (int i = 0; i < getOrderProducts().size(); i++) {
            sumTotalProduct += getOrderProducts().get(i).getQuantity();
        }
        return sumTotalProduct;
    }

    public double getTotalOrderPrice() {
        double totalOrderPrice = 0D;
        for (OrderProduct orderProduct : orderProducts) {
            totalOrderPrice += orderProduct.getTotalPrice();
        }
        return totalOrderPrice;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = null;
        // On regarde si le produit est déjà dans la commande, dans ce cas on ajoute seulement la quantité
        for(OrderProduct op : orderProducts) {
            if (op.getProduct().equals(product)) {
                orderProduct = op;
                op.setQuantity(op.getQuantity() + quantity);
            }
            break;
        }
        // Sinon on ajoute une nouvelle ligne de commande
        if (orderProduct == null) {
            OrderProductId orderProductId = new OrderProductId(product.getId(), id);
            orderProduct = new OrderProduct(orderProductId, product, this, quantity);
            getOrderProducts().add(orderProduct);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", client=" + client +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
