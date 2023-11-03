package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.LoginDetailDTO;
import lk.ijse.easycar.service.LoginDetailService;
import lk.ijse.easycar.service.PaymentService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(params = {"payId", "amount"})
    public ResponseUtil addPayment(){


    }

}
