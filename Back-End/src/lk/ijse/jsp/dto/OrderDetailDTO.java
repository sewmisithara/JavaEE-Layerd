package lk.ijse.jsp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class OrderDetailDTO {
    private String orderID;
    private String code;
    private int qty;
}
