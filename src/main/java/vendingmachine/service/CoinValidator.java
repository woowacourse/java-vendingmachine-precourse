package vendingmachine.service;

public class CoinValidator {

    public void isValid(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로만 이루어져야 합니다.");
        }
        if (!isDivideByTen(number)) {
            throw new IllegalArgumentException("[ERROR] 금액은 10으로 나누어 떨어져야 합니다.");
        }
    }

    public boolean isNumeric(String number) {
        String numericRegex = "[0-9]+";
        return number.matches(numericRegex);
    }

    public boolean isDivideByTen(String number) {
        if (Integer.parseInt(number) % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 10으로 나누어 떨어져야 합니다.");
        }
        return true;
    }
}
