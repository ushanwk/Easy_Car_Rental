package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.CarImageDTO;
import lk.ijse.easycar.service.CarService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil addCar(@RequestBody CarDTO carDTO){
        carService.addCar(carDTO);
        return new ResponseUtil("Ok", "Car Successfully Added", carDTO);
    }


    @PostMapping(params = {"carID"})
    public ResponseUtil addCar(@ModelAttribute CarImageDTO carImageDTO, String carID){
        carImageDTO.setCarID(carID);
        carService.addCar(carImageDTO, carID);
        return new ResponseUtil("Ok", "Car Successfully Added", carID);
    }


    @GetMapping
    public ResponseUtil getAllCar(){
        return new ResponseUtil("Ok", "All Customers", carService.loadAllCar());
    }


}
