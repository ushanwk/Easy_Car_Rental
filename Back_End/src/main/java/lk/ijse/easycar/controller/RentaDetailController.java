package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerImageDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.service.RentalService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentdetail")
@CrossOrigin
public class RentaDetailController {

    @Autowired
    RentalService rentalService;

    @PostMapping(params = {"rentId"})
    public ResponseUtil acceptOrder(String rentId){
        rentalService.updateStatus(rentId);
        return new ResponseUtil("Ok", "Status Updated", rentId);
    }


    @PostMapping(params = {"rentIdDec"})
    public ResponseUtil declineOrder(String rentIdDec){
        rentalService.updateDeclineStatus(rentIdDec);
        return new ResponseUtil("Ok", "Status Updated", rentIdDec);
    }

}
