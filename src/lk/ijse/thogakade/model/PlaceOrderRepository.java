package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 11/15/22 - 7:16 PM   
*/

import lk.ijse.thogakade.entity.Order;
import lk.ijse.thogakade.entity.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderRepository {

    private static ItemRepository itemRepository=new ItemRepository();

    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
            boolean isOrderAdded = OrderRepository.save(new Order(placeOrder.getOrderId(), LocalDate.now(), placeOrder.getCustomerId()));
            if (isOrderAdded) {
                boolean isUpdated = itemRepository.updateQty(placeOrder.getOrderDetails());
//                if (isUpdated) {
//                    boolean isOrderDetailAdded = OrderDetailModel.saveOrderDetails(placeOrder.getOrderDetails());
//                    if (isOrderDetailAdded) {
//                        DBConnection.getInstance().getConnection().commit();
//                        return true;
//                    }
//                }
            }
            return false;

    }
}
