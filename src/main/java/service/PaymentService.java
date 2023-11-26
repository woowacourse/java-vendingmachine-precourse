package service;

import domain.Payment;
import dto.PaymentStatusDto;

public class PaymentService {
    public Payment createPayment(final String payment){
        return Payment.create(payment);
    }

    public PaymentStatusDto createPaymentStatusDto(final Payment payment) {
        return PaymentStatusDto.create(payment.getPayment());
    }
}
