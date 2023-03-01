package lk.ijse.thogakade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order")
public class Order {
    @Id
    private String id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "customerId")
    private String customerId;

}
