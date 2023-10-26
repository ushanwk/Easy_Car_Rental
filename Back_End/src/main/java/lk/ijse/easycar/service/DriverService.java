package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.DriverDTO;

import java.util.List;

public interface DriverService {

    void addDriver(DriverDTO driverDTO);

    List<DriverDTO> loadAllDriver();

}
