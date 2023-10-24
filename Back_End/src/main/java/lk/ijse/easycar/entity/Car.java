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
    String carID;
    String regNo;
    String brand;
    String type;
    String passenger;
    String color;
    String transmissionType;
    String fuelType;
    String extraMileagePrice;
    String currentMileage;
    String wavierPayment;
    String availability;
    String freeMileageDaily;
    String freeMileageDailyPrice;
    String freeMileageMonthly;
    String freeMileageMonthlyPrice;
    String frontImage;
    String RearImage;
    String sideImage;
    String interiorImage;

}
