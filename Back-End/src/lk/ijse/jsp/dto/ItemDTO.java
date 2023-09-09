package lk.ijse.jsp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ItemDTO {
    private String code;
    private String itemName;
    private int qty;
    private double  unitPrice;

}
