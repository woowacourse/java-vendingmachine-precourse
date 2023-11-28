package domain;

import domain.wrapper.PaymentAmount;
import domain.wrapper.Price;
import domain.wrapper.VendingMachineAmount;

public class Payment {
    private final PaymentAmount payment;
    private Payment(final String payment){
        this.payment = PaymentAmount.create(payment);
    }

    private Payment(int payment){
        this.payment = PaymentAmount.create(payment);
    }

    public static Payment create(final String payment){
        return new Payment(payment);
    }

    public int getPayment(){
        return payment.getPaymentAmount();
    }

    public boolean canBuy(Product product) {
        return payment.getPaymentAmount() >= product.getPrice();
    }

    public Payment subtract(int price) {
        return new Payment(payment.getPaymentAmount() - price);
    }
}
