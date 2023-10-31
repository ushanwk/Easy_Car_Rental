package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(RentDetailPK.class)
public class RentDetail {

    @Id
    private String rentID;
    @Id
    private String carID;

    private String driverID;

    @OneToOne(cascade = {CascadeType.ALL})
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "rentID",referencedColumnName = "rentID",insertable = false,updatable = false)
    private Rental rent;

    @ManyToOne
    @JoinColumn(name = "carID",referencedColumnName = "carID",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverID",referencedColumnName = "driverID",insertable = false,updatable = false)
    private Driver driver;

}
