package service;

import domain.Payment;
import dto.PaymentStatusDto;
import repository.UserPaymentRepository;

public class UserPaymentService {

    private final UserPaymentRepository userPaymentRepository = UserPaymentRepository.getInstance();

    public Payment createPayment(final String payment){
        return userPaymentRepository.createPayment(payment);
    }

    public PaymentStatusDto createPaymentStatusDto(final Payment payment) {
        return userPaymentRepository.createPaymentStatusDto(payment);
    }

    public Payment getUserPayment(){
        return userPaymentRepository.get();
    }
}
