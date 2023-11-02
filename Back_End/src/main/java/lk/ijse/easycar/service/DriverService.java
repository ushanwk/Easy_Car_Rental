package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CustomerImageDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.DriverImageDTO;

import java.util.List;

public interface DriverService {

    void addDriver(DriverDTO driverDTO);

    void addDriver(DriverImageDTO driverImageDTO, String driverId);

    List<DriverDTO> loadAllDriver();

    void deleteDriver(String driverId);

}
