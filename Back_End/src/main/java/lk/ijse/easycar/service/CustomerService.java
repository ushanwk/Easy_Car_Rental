package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> loadAllCustomer();

}
