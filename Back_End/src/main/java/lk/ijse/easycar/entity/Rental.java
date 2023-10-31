package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Rental {

    @Id
    private String rentID;
    private String fullPaymentStatus;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "customerID",nullable = false)
    private Customer customerID;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<RentDetail> rentDetails;

}
