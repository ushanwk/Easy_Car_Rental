package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarImageDTO {

    private String carID;
    private MultipartFile frontImage;
    private MultipartFile backImage;
    private MultipartFile sideImage;
    private MultipartFile interiorImage;

}
