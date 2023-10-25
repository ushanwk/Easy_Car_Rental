package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailRepo extends JpaRepository<LoginDetail, String> {
}
