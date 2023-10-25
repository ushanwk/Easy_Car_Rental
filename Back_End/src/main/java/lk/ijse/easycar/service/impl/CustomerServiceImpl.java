package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer(CustomerDTO customerDTO) {

    }

}
