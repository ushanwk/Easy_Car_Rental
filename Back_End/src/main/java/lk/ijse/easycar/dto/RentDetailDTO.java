package lk.ijse.easycar.dto;

import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.Payment;
import lk.ijse.easycar.entity.Rental;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentDetailDTO {

    private Rental rentID;
    private Car carID;
    private Driver driverID;
    private Payment paymentID;

}
