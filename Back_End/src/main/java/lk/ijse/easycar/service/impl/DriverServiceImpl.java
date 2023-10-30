package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.CustomerImageDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.DriverImageDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
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

    @Override
    public void addDriver(DriverImageDTO dto, String driverId) {

        Driver driver = driverRepo.findById(driverId).get();

        try {

            if (dto.getLicenseImage () != null) {


                byte[] fileBytes = dto.getLicenseImage ().getBytes ();


                String projectPath = "/Users/ushan_kaushalya/SoftwareEngineeringEDU/IJSE/2nd Semester/Advance API Development/CourseWork/Easy_Car_Rental/Front_End/assest";
                Path location = Paths.get (projectPath + "/projectimages/driverimages/driver_" + dto.getDriverId () + ".jpeg");

                Files.write (location, fileBytes);

                dto.getLicenseImage ().transferTo (location);

            }

        } catch (IOException e) {
            System.out.println (e);
            throw new RuntimeException (e);
        }

        driver.setLicenseImage ("/assets/projectImages/driverimages/driver_" + dto.getLicenseImage ()+".jpeg");


        driverRepo.save(driver);

    }

    @Override
    public List<DriverDTO> loadAllDriver() {
        List<Driver> drivers = driverRepo.findAll();
        return mapper.map(drivers, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

}
