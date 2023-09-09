package lk.ijse.jsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetail {
    private String orderId;
    private String itemID;
    private int qty;
}
