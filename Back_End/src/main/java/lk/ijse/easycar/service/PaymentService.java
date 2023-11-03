package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.PaymentDTO;

public interface PaymentService {

    void addPayment(PaymentDTO paymentDTO);

    PaymentDTO getById(String id);

}
