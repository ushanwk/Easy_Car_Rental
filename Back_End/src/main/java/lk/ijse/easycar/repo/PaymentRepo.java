package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {
}
