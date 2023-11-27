package repository;

import domain.Payment;
import dto.PaymentStatusDto;

public class UserPaymentRepository {
    private static final UserPaymentRepository userPaymentRepository = new UserPaymentRepository();
    private Payment userPayment;

    private UserPaymentRepository(){

    }

    public static UserPaymentRepository getInstance() {
        return userPaymentRepository;
    }

    public Payment createPayment(final String payment){
        this.userPayment = Payment.create(payment);
        return userPayment;
    }

    public PaymentStatusDto createPaymentStatusDto(final Payment payment) {
        return PaymentStatusDto.create(payment.getPayment());
    }

    public Payment get() {
        return userPayment;
    }

    public void update(Payment payment) {
        this.userPayment = payment;
    }
}
