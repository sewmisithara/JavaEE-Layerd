package lk.ijse.jsp.dao.custom;



import lk.ijse.jsp.dao.CrudDAO;
import lk.ijse.jsp.entity.Item;

import java.sql.Connection;

public interface ItemDAO extends CrudDAO<Connection, Item, String> {
}
