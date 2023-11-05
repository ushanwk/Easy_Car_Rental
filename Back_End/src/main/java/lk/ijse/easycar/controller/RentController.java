package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerIdGenerateDTO;
import lk.ijse.easycar.dto.RentalIdGenrateDTO;
import lk.ijse.easycar.service.RentalService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentalService rentalService;

    @GetMapping
    public ResponseUtil getAllRents(){
        return new ResponseUtil("Ok", "All Customers", rentalService.loadAllRents());
    }

}
