package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {

    @Id
    private String driverID;
    private String drivingLicenceNo;
    private String driverName;
    private String email;
    private String licenseImage;
    private String availability;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "userName",referencedColumnName = "userName",nullable = false)
    private User userName;

}
