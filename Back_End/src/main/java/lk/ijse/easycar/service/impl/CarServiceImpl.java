package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.CarImageDTO;
import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.service.CarService;
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
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addCar(CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);
        carRepo.save(car);
    }

    @Override
    public void addCar(CarImageDTO dto, String carID) {

        Car car = carRepo.findById(dto.getCarID()).get();

        try {

            if(dto.getFrontImage() != null && dto.getBackImage() != null && dto.getSideImage() != null && dto.getInteriorImage() != null){

                byte[] frontFileBytes = dto.getFrontImage ().getBytes ();
                byte[] backFileBytes = dto.getBackImage ().getBytes ();
                byte[] sideFileBytes = dto.getSideImage().getBytes();
                byte[] interiorFileBytes = dto.getInteriorImage().getBytes();

                String projectPath = "/Users/ushan_kaushalya/SoftwareEngineeringEDU/IJSE/2nd Semester/Advance API Development/CourseWork/Easy_Car_Rental/Front_End/assest";

                Path frontLocation = Paths.get (projectPath + "/projectimages/carimages/frontimages/front_" + dto.getCarID () + ".jpeg");
                Path backLocation = Paths.get (projectPath + "/projectimages/carimages/backimages/back_" + dto.getCarID () + ".jpeg");
                Path sidetLocation = Paths.get (projectPath + "/projectimages/carimages/sideimages/side_" + dto.getCarID () + ".jpeg");
                Path interiorLocation = Paths.get (projectPath + "/projectimages/carimages/interiorimages/interior_" + dto.getCarID () + ".jpeg");

                Files.write (frontLocation, frontFileBytes);
                Files.write (backLocation, backFileBytes);
                Files.write (sidetLocation, sideFileBytes);
                Files.write (interiorLocation, interiorFileBytes);

                dto.getFrontImage().transferTo (frontLocation);
                dto.getBackImage().transferTo (backLocation);
                dto.getInteriorImage().transferTo (interiorLocation);
                dto.getSideImage().transferTo (sidetLocation);

            }

        }catch(IOException e){
            System.out.println (e);
            throw new RuntimeException (e);
        }

        car.setFrontImage ("/assets/projectImages/carimages/frontimages/front_" + dto.getCarID () + ".jpeg");
        car.setBackImage ("/assets/projectImages/carimages/backimages/back_" + dto.getCarID () + ".jpeg");
        car.setSideImage ("/assets/projectImages/carimages/sideimages/side_" + dto.getCarID () + ".jpeg");
        car.setFrontImage ("/assets/projectImages/carimages/interiorimages/interior" + dto.getCarID () + ".jpeg");


    }

    @Override
    public List<CarDTO> loadAllCar() {
        List<Car> cars = carRepo.findAll();
        return mapper.map(cars, new TypeToken<List<CarDTO>>() {
        }.getType());
    }
}
