package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CartDetail {
    private String orderId;
    private String code;
    private int qty;
    private String description;
    private double unitPrice;

}
