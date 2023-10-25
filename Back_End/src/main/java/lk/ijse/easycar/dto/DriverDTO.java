package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverDTO {

    private String driverID;
    private String drivingLicenceNo;
    private String driverName;
    private String email;
    private String contactNo;
    private String frontImage;
    private String backImage;

}
