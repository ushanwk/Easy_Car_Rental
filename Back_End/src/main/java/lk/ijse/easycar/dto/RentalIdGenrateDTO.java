package lk.ijse.easycar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RentalIdGenrateDTO {
    private String value;
    public RentalIdGenrateDTO(String lastIndex){
        value = lastIndex;
    }
}
