package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CustomerIdGenerateDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.LoginDetailDTO;
import lk.ijse.easycar.dto.LoginDetailIdGenerateDTO;

public interface LoginDetailService {

    void addLoginDetail(LoginDetailDTO loginDetailDTO);

    public LoginDetailIdGenerateDTO LoginDetailIdGenerate();

}
