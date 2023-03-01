package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 11/1/22 - 10:36 AM   
*/

import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.util.CrudUtil;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository {

    Session session= FactoryConfiguration.getInstance().getSession();
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Transaction transaction=session.beginTransaction();
        try{
            String id = (String) session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Transaction transaction=session.beginTransaction();
        try{
            Customer customer = (Customer) session.get(id, Customer.class);
            transaction.commit();
            return customer;
        }catch (Exception e){
            transaction.rollback();
            return null;
        }
    }

    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
