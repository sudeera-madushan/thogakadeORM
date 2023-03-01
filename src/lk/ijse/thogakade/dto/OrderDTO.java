package lk.ijse.thogakade.dto;


import java.time.LocalDate;

public class OrderDTO {
    private String id;
    private LocalDate date;
    private String customerId;

    public OrderDTO(String id, LocalDate date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public OrderDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
