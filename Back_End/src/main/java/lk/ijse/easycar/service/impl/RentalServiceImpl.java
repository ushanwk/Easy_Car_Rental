package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.dto.RentalIdGenrateDTO;
import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Rental;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.repo.RentRepo;
import lk.ijse.easycar.repo.RentalRepo;
import lk.ijse.easycar.service.RentalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepo rentalRepo;
    @Autowired
    RentRepo rentRepo;
    @Autowired
    ModelMapper mapper;
    @Autowired
    CarRepo carRepo;

    @Override
    public void addRental(RentalDTO rentalDTO) {
        Rental rental = mapper.map(rentalDTO, Rental.class);
        System.out.println(rental.getRentID());
        rentalRepo.save(rental);
    }

    @Override
    public List<RentalDTO> loadAllRents() {
        List<Rental> rents = rentalRepo.findAll();
        return mapper.map(rents, new TypeToken<List<RentalDTO>>() {
        }.getType());
    }

    @Override
    public void updateStatus(String rentID) {
        Rental rent = rentalRepo.findById(rentID).get();
        rent.setStatus("ACCEPTED");
        addRental(mapper.map(rent, RentalDTO.class));
    }

    @Override
    public void updateDeclineStatus(String rentID) {
        Rental rent = rentalRepo.findById(rentID).get();
        rent.setStatus("DECLINED");
        addRental(mapper.map(rent, RentalDTO.class));

        for(int i = 0; i < rent.getRentDetails().size(); i++){

            Car car = rent.getRentDetails().get(i).getCar();
            car.setAvailability("AVAILABLE");

            carRepo.save(car);

        }
    }

    @Override
    public RentalIdGenrateDTO rentIdGenerate() {
        return new RentalIdGenrateDTO(rentRepo.getLastIndex());
    }


}
