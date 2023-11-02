package lk.ijse.easycar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginDetailIdGenerateDTO {
    private String value;
    public LoginDetailIdGenerateDTO(String lastIndex){
        value = lastIndex;
    }
}
