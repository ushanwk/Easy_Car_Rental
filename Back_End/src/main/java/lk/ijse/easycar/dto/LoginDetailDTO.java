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
public class LoginDetailDTO {

    private String loginID;
    private User userName;
    private String date;
    private String time;

}
