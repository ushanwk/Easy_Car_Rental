package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.User;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.repo.UserRepo;
import lk.ijse.easycar.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        userRepo.save(user);
    }

    @Override
    public List<UserDTO> loadAllUsers() {
        List<User> users = userRepo.findAll();
        return mapper.map(users, new TypeToken<List<UserDTO>>() {
        }.getType());
    }


}
