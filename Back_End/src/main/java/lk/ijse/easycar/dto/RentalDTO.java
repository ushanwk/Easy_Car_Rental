package lk.ijse.easycar.dto;

import lk.ijse.easycar.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalDTO {

    private String rentID;
    private String customerID;
    private String pickupDate;
    private String pickupTime;
    private String status;
    private String declineReason;
    private List<RentDetailDTO> rentDetails;

}
