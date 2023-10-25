package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
}
