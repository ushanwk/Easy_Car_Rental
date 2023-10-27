package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDTO {

    private String carID;
    private String regNo;
    private String brand;
    private String type;
    private String passenger;
    private String color;
    private String transmissionType;
    private String fuelType;
    private String extraMileagePrice;
    private String currentMileage;
    private String wavierPayment;
    private String availability;
    private String freeMileageDaily;
    private String freeMileageDailyPrice;
    private String freeMileageMonthly;
    private String freeMileageMonthlyPrice;
    private String frontImage;
    private String backImage;
    private String sideImage;
    private String interiorImage;

}
