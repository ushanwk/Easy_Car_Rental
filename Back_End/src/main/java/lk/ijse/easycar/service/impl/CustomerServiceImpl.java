package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = mapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
    }

}
