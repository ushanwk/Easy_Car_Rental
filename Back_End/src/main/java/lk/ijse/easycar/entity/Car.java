package lk.ijse.easycar.entity;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {

    @Id
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
