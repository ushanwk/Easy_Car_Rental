package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> loadAllUsers();

}
