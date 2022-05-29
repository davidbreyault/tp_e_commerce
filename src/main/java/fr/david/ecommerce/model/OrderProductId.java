package fr.david.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductId implements Serializable {

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "order_id")
    private Long order_id;

    public OrderProductId() {
        super();
    }

    public OrderProductId(Long product_id, Long order_id) {
        this.product_id = product_id;
        this.order_id = order_id;
    }
}
