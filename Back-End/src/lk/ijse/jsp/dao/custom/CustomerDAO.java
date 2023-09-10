package lk.ijse.jsp.dao.custom;

import lk.ijse.jsp.dao.CrudDAO;
import lk.ijse.jsp.entity.Customer;


import java.sql.Connection;

public interface CustomerDAO extends CrudDAO<Connection, Customer, String> {
}