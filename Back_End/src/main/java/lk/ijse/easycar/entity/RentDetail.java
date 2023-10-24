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
public class RentDetail implements Serializable {

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "rentID",referencedColumnName = "rentID",nullable = false)
    private Rental rentID;

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "carID",referencedColumnName = "carID",nullable = false)
    private Car carID;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "driverID",referencedColumnName = "driverID",nullable = false)
    private Driver driverID;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "paymentID",referencedColumnName = "paymentID",nullable = false)
    private Payment paymentID;

}
