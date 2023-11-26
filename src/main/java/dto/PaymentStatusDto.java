package dto;

public class PaymentStatusDto {
    private final int payment;

    public PaymentStatusDto(final int payment){
        this.payment = payment;
    }

    public static PaymentStatusDto create(final int payment) {
        return new PaymentStatusDto(payment);
    }

    public int getPayment(){
        return payment;
    }
}
