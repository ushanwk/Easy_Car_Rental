package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.CustomerIdGenerateDTO;
import lk.ijse.easycar.dto.CustomerImageDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Override
    public List<CustomerDTO> loadAllCustomer() {
        List<Customer> customer = customerRepo.findAll();
        return mapper.map(customer, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void addCustomer(CustomerImageDTO dto) {

        Customer customer = customerRepo.findById(dto.getCustomerID()).get();

        try {

            if (dto.getFrontImage () != null && dto.getBackImage () != null) {

                byte[] frontFileBytes = dto.getFrontImage ().getBytes ();
                byte[] backFileBytes = dto.getBackImage ().getBytes ();


                String projectPath = "/Users/ushan_kaushalya/SoftwareEngineeringEDU/IJSE/2nd Semester/Advance API Development/CourseWork/Easy_Car_Rental/Front_End/assest";
                Path frontLocation = Paths.get (projectPath + "/projectimages/customerimages/frontimage/front_" + dto.getCustomerID () + ".jpeg");
                Path backLocation = Paths.get (projectPath + "/projectimages/customerimages/backimage/back_" + dto.getCustomerID () + ".jpeg");

                Files.write (frontLocation, frontFileBytes);
                Files.write (backLocation, backFileBytes);

                dto.getFrontImage ().transferTo (frontLocation);
                dto.getBackImage ().transferTo (backLocation);
            }

        } catch (IOException e) {
            System.out.println (e);
            throw new RuntimeException (e);
        }

        customer.setFrontImage ("/assets/projectImages/customerimages/frontimage/front_" + dto.getCustomerID ()+".jpeg");
        customer.setBackImage ("/assets/projectImages/customerimages/frontimage/back_" + dto.getCustomerID ()+".jpeg");

        customerRepo.save(customer);

    }

    @Override
    public CustomerIdGenerateDTO customerIdGenerate() {
        return new CustomerIdGenerateDTO(customerRepo.getLastIndex());
    }

    @Override
    public CustomerDTO getCusByUsername(String username) {
        Customer customerByUsername = customerRepo.getCustomerByUsername(username);
        CustomerDTO customerDTO = mapper.map(customerByUsername, CustomerDTO.class);

        return customerDTO;
    }

}
