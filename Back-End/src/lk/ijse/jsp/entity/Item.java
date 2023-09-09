package lk.ijse.jsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String code;
    private String itemName;
    private int qty;
    private double unitPrice;
}
