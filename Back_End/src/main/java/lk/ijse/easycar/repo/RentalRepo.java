package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, String> {
}