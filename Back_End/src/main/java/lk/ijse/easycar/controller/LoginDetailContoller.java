package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.CustomerIdGenerateDTO;
import lk.ijse.easycar.dto.LoginDetailDTO;
import lk.ijse.easycar.dto.LoginDetailIdGenerateDTO;
import lk.ijse.easycar.service.LoginDetailService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logindetail")
@CrossOrigin
public class LoginDetailContoller {

    @Autowired
    LoginDetailService loginDetailService;

    @PostMapping
    public ResponseUtil addLoginDetail(@RequestBody LoginDetailDTO loginDetailDTO){

        System.out.println(loginDetailDTO.getLoginID());
        System.out.println(loginDetailDTO.getDate());
        System.out.println(loginDetailDTO.getTime());
        System.out.println(loginDetailDTO.getLoginID());

        loginDetailService.addLoginDetail(loginDetailDTO);
        return new ResponseUtil("Ok", "Car Successfully Added", loginDetailDTO);
    }

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody LoginDetailIdGenerateDTO customerIdGenerate() {
        return loginDetailService.LoginDetailIdGenerate();
    }

}
