package lk.ijse.thogakade.dto;

import java.util.ArrayList;

public class PlaceOrderDTO {
    private String customerId;
    private String orderId;
    private ArrayList<CartDetailDTO> orderDetails = new ArrayList<>();

    public PlaceOrderDTO(String customerId, String orderId, ArrayList<CartDetailDTO> orderDetails) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public PlaceOrderDTO() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<CartDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
