package lk.ijse.jsp.dao.custom;



import lk.ijse.jsp.dao.CrudDAO;
import lk.ijse.jsp.entity.OrderDetail;

import java.sql.Connection;

public interface OrderDetailDAO extends CrudDAO<Connection, OrderDetail, String> {
}
