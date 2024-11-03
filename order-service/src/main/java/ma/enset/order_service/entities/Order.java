package ma.enset.order_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.order_service.enums.OrderStatus;
import ma.enset.order_service.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getTotal(){
        double somme=0;
        for(ProductItem pi: productItems){
            somme += pi.getPrice();
        }
        return somme;
    }
}
