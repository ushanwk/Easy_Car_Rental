package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    void addRental(RentalDTO rentalDTO);

    List<RentalDTO> loadAllRents();

    void updateStatus(String rentID);

}
