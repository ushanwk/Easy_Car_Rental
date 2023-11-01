package lk.ijse.easycar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CustomerIdGenerateDTO {
        private String value;
        public CustomerIdGenerateDTO(String lastIndex) {
            this.value=lastIndex;
        }
}
