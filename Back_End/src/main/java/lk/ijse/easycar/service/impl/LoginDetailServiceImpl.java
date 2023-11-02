package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.LoginDetailDTO;
import lk.ijse.easycar.dto.LoginDetailIdGenerateDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.LoginDetail;
import lk.ijse.easycar.repo.LoginDetailRepo;
import lk.ijse.easycar.service.LoginDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginDetailServiceImpl implements LoginDetailService {

    @Autowired
    LoginDetailRepo loginDetailRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addLoginDetail(LoginDetailDTO loginDetailDTO) {
        LoginDetail loginDetail = mapper.map(loginDetailDTO, LoginDetail.class);
        loginDetailRepo.save(loginDetail);
    }

    @Override
    public LoginDetailIdGenerateDTO LoginDetailIdGenerate() {
        return new LoginDetailIdGenerateDTO(loginDetailRepo.getLastIndex());
    }

}
