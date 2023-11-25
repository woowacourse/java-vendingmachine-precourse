package domain.wrapper;

import domain.constant.Constant;

import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.RANGE_MESSAGE;

public class PaymentAmount {
    private final int paymentAmount;

    private PaymentAmount(final String payment){
        validateNameBlank(payment);
        int amount = validateType(payment);
        this.paymentAmount = validateRange(amount);
    }

    public static PaymentAmount create(final String payment){
        return new PaymentAmount(payment);
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
}
