package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.CustomerIdGenerateDTO;
import lk.ijse.easycar.dto.CustomerImageDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.service.UserService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

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
        userService.addUser(new UserDTO(customerDTO.getUsername(), customerDTO.getUser().getPassword(), customerDTO.getUser().getRole()));
        customerService.addCustomer(customerDTO);
        return new ResponseUtil("Ok", "Customer Successfully Added", customerDTO);
    }

    @PostMapping(params = {"customerId"})
    public ResponseUtil addCustomer(@ModelAttribute CustomerImageDTO customerImageDTO, String customerId){
        customerImageDTO.setCustomerID(customerId);
        customerService.addCustomer(customerImageDTO);
        return new ResponseUtil("Ok", "Customer Image Successfully Added", customerId);
    }


    @GetMapping
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil("Ok", "All Customers", customerService.loadAllCustomer());
    }


    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomerIdGenerateDTO customerIdGenerate() {
        return customerService.customerIdGenerate();
    }


    @GetMapping(params = {"username"})
    public ResponseUtil customerFindByUsername(String username) {
        return new ResponseUtil("Ok", "Customer Search Done", customerService.getCusByUsername(username));
    }



}
