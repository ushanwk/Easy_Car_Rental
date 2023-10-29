package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.CarImageDTO;

import java.util.List;

public interface CarService {

    void addCar(CarDTO carDTO);

    void addCar(CarImageDTO carImageDTO, String carID);

    List<CarDTO> loadAllCar();

}
