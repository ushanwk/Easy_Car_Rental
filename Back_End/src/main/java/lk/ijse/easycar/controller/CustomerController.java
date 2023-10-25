package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.service.UserService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseUtil addCustomer(@RequestBody CustomerDTO customerDTO){
        userService.addUser(new UserDTO(customerDTO.getUsername(), "123", "Customer"));
        customerService.addCustomer(customerDTO);
        return new ResponseUtil("Ok", "Customer Successfully Added", customerDTO);
    }

}
