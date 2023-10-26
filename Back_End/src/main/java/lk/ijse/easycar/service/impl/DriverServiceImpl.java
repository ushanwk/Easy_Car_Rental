package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO driverDTO) {
        Driver driver = mapper.map(driverDTO, Driver.class);
        driverRepo.save(driver);
    }

}
