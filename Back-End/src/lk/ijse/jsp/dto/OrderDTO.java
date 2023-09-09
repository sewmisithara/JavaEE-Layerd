package lk.ijse.jsp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class OrderDTO {
    private String orderID;
    private Date date;
    private String cusID;
    private  Integer discount;
    private Double total;
    private List<lk.ijse.jsp.dto.OrderDetailDTO> orderDetails;

}
