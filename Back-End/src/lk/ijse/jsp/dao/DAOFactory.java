package lk.ijse.jsp.dao;

import lk.ijse.jsp.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.jsp.dao.custom.impl.ItemDAOImpl;
import lk.ijse.jsp.dao.custom.impl.OrderDAOImpl;
import lk.ijse.jsp.dao.custom.impl.OrderDetailDAOImpl;


public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }
    }

}
