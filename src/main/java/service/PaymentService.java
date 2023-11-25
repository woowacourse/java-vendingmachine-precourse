package service;

import domain.Payment;
import domain.PossesionAmount;

public class PaymentService {
    public Payment createPayment(final String payment){
        return Payment.create(payment);
    }
}
