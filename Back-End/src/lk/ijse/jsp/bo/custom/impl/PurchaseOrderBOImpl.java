package lk.ijse.jsp.bo.custom.impl;



import lk.ijse.jsp.bo.custom.PurchaseOrderBO;
import lk.ijse.jsp.dao.DAOFactory;
import lk.ijse.jsp.dao.custom.ItemDAO;
import lk.ijse.jsp.dao.custom.OrderDAO;
import lk.ijse.jsp.dao.custom.OrderDetailDAO;
import lk.ijse.jsp.dto.CustomerDTO;
import lk.ijse.jsp.dto.ItemDTO;
import lk.ijse.jsp.dto.OrderDTO;
import lk.ijse.jsp.dto.OrderDetailDTO;
import lk.ijse.jsp.entity.Item;
import lk.ijse.jsp.entity.Order;
import lk.ijse.jsp.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean purchaseOrder(Connection connection, OrderDTO order) throws SQLException, ClassNotFoundException {
        connection.setAutoCommit(false);
        if (!orderDAO.save(connection, new Order(order.getOrderID(), order.getDate(), order.getCusID(), order.getDiscount(),order.getTotal()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
        for (OrderDetailDTO detailDTO : order.getOrderDetails()) {
            if (!orderDetailDAO.save(connection, new OrderDetail(detailDTO.getOrderID(), detailDTO.getCode(), detailDTO.getQty()))) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            ItemDTO item = searchItem(connection, detailDTO.getCode());
            item.setQty(item.getQty() - detailDTO.getQty());

            if (!itemDAO.update(connection, new Item(item.getCode(), item.getItemName(), item.getQty(), item.getUnitPrice()))) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }
        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO searchItem(Connection connection, String code) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.search(connection, code);
        return new ItemDTO(item.getCode(), item.getItemName(), item.getQty(), item.getUnitPrice());
    }

    @Override
    public boolean checkItemIsAvailable(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean checkCustomerIsAvailable(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderID(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}
