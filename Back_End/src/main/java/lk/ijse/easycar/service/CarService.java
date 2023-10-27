package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CarDTO;

import java.util.List;

public interface CarService {

    void addCar(CarDTO carDTO);

    List<CarDTO> loadAllCar();

}
