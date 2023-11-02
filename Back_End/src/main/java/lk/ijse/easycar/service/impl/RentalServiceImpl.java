package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentalDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Rental;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.repo.RentalRepo;
import lk.ijse.easycar.service.RentalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepo rentalRepo;
    @Autowired
    ModelMapper mapper;

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
}
