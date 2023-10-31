package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentDetailDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerrent")
@CrossOrigin
public class CustomerRentController {

    @PostMapping
    public ResponseUtil addRent(@RequestBody RentalDTO rentalDTO){

        List<RentDetailDTO> rentDetails = rentalDTO.getRentDetails();

        for (int i = 0; i < rentDetails.size(); i++){
            System.out.println(rentDetails.get(i).getCarID());
        }

        return new ResponseUtil("Ok", "Customer Successfully Added", null);

    }

}
