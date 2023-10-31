package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerrent")
@CrossOrigin
public class CustomerRentController {

    @PostMapping
    public ResponseUtil addRent(@RequestBody RentalDTO rentalDTO){


        return new ResponseUtil("Ok", "Customer Successfully Added", null);

    }

}
