package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
