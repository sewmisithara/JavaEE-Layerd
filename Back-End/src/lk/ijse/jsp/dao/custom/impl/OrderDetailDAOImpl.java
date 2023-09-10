package lk.ijse.jsp.dao.custom.impl;



import lk.ijse.jsp.dao.SQLUtil;
import lk.ijse.jsp.dao.custom.OrderDetailDAO;
import lk.ijse.jsp.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public ArrayList<OrderDetail> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Connection connection, OrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "INSERT INTO OrderDetail VALUES (?,?,?,?)", entity.getOrderId(), entity.getItemID(), entity.getQty(), entity.getQty(), entity.getQty());
    }

    @Override
    public boolean update(Connection connection, OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail search(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exit(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
