package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    @author DanujaV
    @created 11/15/22 - 9:44 PM
*/
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
public class Item {
    @Id
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "qtyOnHand")
    private int qtyOnHand;
}
