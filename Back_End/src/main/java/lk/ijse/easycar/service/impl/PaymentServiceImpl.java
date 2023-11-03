package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.PaymentDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.Payment;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.repo.PaymentRepo;
import lk.ijse.easycar.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addPayment(PaymentDTO paymentDTO) {
        paymentRepo.save(mapper.map(paymentDTO, Payment.class));
    }
}
