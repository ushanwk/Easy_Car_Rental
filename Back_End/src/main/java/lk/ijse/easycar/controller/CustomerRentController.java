package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentDetailDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.service.RentalService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerrent")
@CrossOrigin
public class CustomerRentController {

    @Autowired
    RentalService rentalService;

    @PostMapping
    public ResponseUtil addRent(@RequestBody RentalDTO rentalDTO){

        rentalService.addRental(rentalDTO);

        return new ResponseUtil("Ok", "Customer Successfully Added", null);
    }

}
