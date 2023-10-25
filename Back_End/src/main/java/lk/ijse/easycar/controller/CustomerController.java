package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseUtil addCustomer(CustomerDTO customerDTO){
        System.out.println(customerDTO);
//        customerService.addCustomer(customerDTO);
        return new ResponseUtil("Ok", "Customer Successfully Added", customerDTO);
    }

}
