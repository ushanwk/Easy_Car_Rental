package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginDetailRepo extends JpaRepository<LoginDetail, String> {

    @Query(value = "SELECT loginId FROM LoginDetail ORDER BY loginId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

}
