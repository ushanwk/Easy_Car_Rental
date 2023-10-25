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

public class Customer {

    @Id
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String licenseNo;
    private String frontImage;
    private String backImage;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "userName",referencedColumnName = "userName",nullable = false)
    private User userName;

}
