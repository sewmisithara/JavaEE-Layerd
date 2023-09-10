package lk.ijse.jsp.bo.custom.impl;

import lk.ijse.jsp.bo.SuperBO;
import lk.ijse.jsp.bo.custom.CustomerBO;
import lk.ijse.jsp.dao.DAOFactory;
import lk.ijse.jsp.dao.custom.CustomerDAO;
import lk.ijse.jsp.dto.CustomerDTO;
import lk.ijse.jsp.entity.Customer;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO, SuperBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll(connection);
        for (Customer customer : all
        ) {
            allCustomers.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public boolean saveCustomer(Connection connection, CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.save(connection, new Customer(customer.getCusID(), customer.getCusName(), customer.getCusAddress()));
    }

    @Override
    public boolean updateCustomer(Connection connection, CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(connection, new Customer(customer.getCusID(), customer.getCusName(), customer.getCusAddress()));
    }

    @Override
    public boolean exitsCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(connection, id);
    }

    @Override
    public String generateNewCustomerId(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> filterCustomers(Connection connection, String field, String value) throws SQLException, ClassNotFoundException {
        return null;
    }
}
