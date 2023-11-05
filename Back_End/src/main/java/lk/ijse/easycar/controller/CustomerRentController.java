package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.*;
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

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody RentalIdGenrateDTO rentIdGenerate() {
        System.out.println("lllllllllllll");
        System.out.println(rentalService.rentIdGenerate());
        return rentalService.rentIdGenerate();
    }

}
