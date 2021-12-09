package vendingmachine.util;

import vendingmachine.constant.ErrorMessage;

public class NumberValidation {
    protected void numberValidation(String number) throws IllegalArgumentException {
        isDigitString(number);
        isBlank(number);
    }

    protected void isDigitString(String number) throws IllegalArgumentException {
        for (char c : number.toCharArray()) {
            isDigit(c);
        }
    }

    protected void isDigit(char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT_MESSAGE.print() + "잘못들어온 문자 : " + c);
        }
    }

    protected void isBlank(String number) throws IllegalArgumentException {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE.print());
        }
    }
}
