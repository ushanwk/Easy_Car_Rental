package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.DriverImageDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.service.DriverService;
import lk.ijse.easycar.service.UserService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseUtil addDriver(@RequestBody DriverDTO driverDTO){
        userService.addUser(new UserDTO(driverDTO.getUser().getUsername(), driverDTO.getUser().getPassword(), driverDTO.getUser().getRole()));
        driverService.addDriver(driverDTO);
        return new ResponseUtil("Ok", "Driver Successfully Added", driverDTO);
    }

    @PostMapping(params = {"driverId"})
    public ResponseUtil addDriver(@ModelAttribute DriverImageDTO driverImageDTO, String driverId){
        driverImageDTO.setDriverId(driverId);
        driverService.addDriver(driverImageDTO, driverId);
        return new ResponseUtil("Ok", "Driver Successfully Added", driverId);
    }


    @GetMapping
    public ResponseUtil getAllDriver(){
        return new ResponseUtil("Ok", "All Drivers", driverService.loadAllDriver());
    }

    @DeleteMapping(params = {"driverId"})
    public ResponseUtil deleteDriver(String driverId){
        driverService.deleteDriver(driverId);
        return new ResponseUtil("Ok", "All Deleted", driverId);
    }


}
