package domain.wrapper;

import domain.constant.Constant;

import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.RANGE_MESSAGE;

public class PaymentAmount {
    private final int paymentAmount;

    private PaymentAmount(final String payment){
        validateNameBlank(payment);
        int amount = validateType(payment);
        this.paymentAmount = validateDivisibleBy1000(validateRange(amount));
    }

    private PaymentAmount(final int paymentAmount){
        this.paymentAmount = paymentAmount;
    }

    public static PaymentAmount create(final String payment){
        return new PaymentAmount(payment);
    }

    public static PaymentAmount create(final int paymentAmount){
        return new PaymentAmount(paymentAmount);
    }

    public int getPaymentAmount(){
        return paymentAmount;
    }

    private void validateNameBlank(final String payment) {
        if (payment == null || payment.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "투입금액"));
        }
    }

    private int validateType(final String amount) {
        int count;
        try {
            count = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "투입금액"));
        }
        return count;
    }

    private int validateRange(final int amount) {
        if (amount <= Constant.ZERO.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
        }
        return amount;
    }

    private int validateDivisibleBy1000(final int amount){
        if(amount % Constant.ONE_THOUSANE.getValue() != Constant.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(UNIT_MESSAGE.getValue(), Constant.ONE_THOUSANE.getValue()));
        }
        return amount;
    }
}
