package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 11/15/22 - 7:45 PM   
*/

import lk.ijse.thogakade.entity.CartDetail;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.util.CrudUtil;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemRepository {
    private Session session= FactoryConfiguration.factoryConfiguration.getSession();

    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM ItemDTO";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    public  Item search(String code) throws SQLException, ClassNotFoundException {
        Transaction transaction=session.beginTransaction();
        try{
            Item item = (Item) session.get(code, Item.class);
            transaction.commit();
            return item;
        }catch (Exception e){
            transaction.rollback();
            return null;
        }
    }

    public boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(new Item(cartDetail.getCode(), cartDetail.getDescription(), cartDetail.getUnitPrice(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
        Transaction transaction=session.beginTransaction();
        try{
            session.update(item);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }
}
