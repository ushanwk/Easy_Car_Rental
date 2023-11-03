package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepo extends JpaRepository<Rental, String> {


}
