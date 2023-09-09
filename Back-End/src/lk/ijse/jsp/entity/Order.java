package lk.ijse.jsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Order {
    private String orderID;
    private Date date;
    private String customerID;
    private  Integer discount;
    private Double total;
}
