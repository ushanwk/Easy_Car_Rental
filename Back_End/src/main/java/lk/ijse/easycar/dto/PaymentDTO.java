package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDTO {

    private String paymentID;
    private double waiverDeductions;
    private String waiverSlip;
    private double extraMileagePayment;

}
