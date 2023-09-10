package lk.ijse.jsp.dao.custom;

import lk.ijse.jsp.dao.CrudDAO;
import lk.ijse.jsp.entity.Order;


import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Connection, Order, String> {
    String generateNewOrderId(Connection connection) throws SQLException, ClassNotFoundException;
}
