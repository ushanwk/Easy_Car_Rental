package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerrent")
@CrossOrigin
public class CustomerRentController {

    @PostMapping
    public ResponseUtil addCustomer(){



        return new ResponseUtil("Ok", "Customer Successfully Added", null);

    }

}
