package lk.ijse.easycar.dto;

import lk.ijse.easycar.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private String frontImage;
    private String backImage;
    private String username;
    private User user;

}
