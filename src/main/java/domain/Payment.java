package domain;

import domain.wrapper.PaymentAmount;
import domain.wrapper.VendingMachineAmount;

public class Payment {
    private final PaymentAmount payment;
    private Payment(final String payment){
        this.payment = PaymentAmount.create(payment);
    }

    public static Payment create(final String payment){
        return new Payment(payment);
    }

    //쉽게 말해, getter를 통해 얻은 상태값으로 하려고 했던 '행동'을
    // 그 상태값을 가진 객체가 하도록 '행동'의 주체를 옮기는 것이다.

    public int getPayment(){
        return payment.getPaymentAmount();
    }
}
