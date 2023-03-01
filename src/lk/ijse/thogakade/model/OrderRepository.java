package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 11/15/22 - 11:55 PM   
*/

import lk.ijse.thogakade.entity.Order;
import lk.ijse.thogakade.util.CrudUtil;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository {
    private static Session session= FactoryConfiguration.factoryConfiguration.getSession();

    public static boolean save(Order order) throws SQLException, ClassNotFoundException {
        Transaction transaction=session.beginTransaction();
        try{
            session.save(order);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM OrderDTO ORDER BY id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(result.getString(null));
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("D0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "D0" + id;
        }
        return "O001";

    }

}
