package lk.ijse.thogakade.entity;

/*
    @author DanujaV
    @created 11/15/22 - 11:46 PM   
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "placeOrder")
public class PlaceOrder {
    private String customerId;
    @Id
    private String orderId;
    @ElementCollection
    @CollectionTable(name = "orderDetails",joinColumns = @JoinColumn(name="orderId"))
    private ArrayList<CartDetail> orderDetails = new ArrayList<>();

}
