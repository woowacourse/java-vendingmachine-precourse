package vendingmachine.domain;

public class MachineMoney {
    final static int MIN_COIN_UNIT = 10;

    private int money;

    public MachineMoney(String money) throws IllegalArgumentException {
        machineMoneyValidation(money);
        this.money = Integer.parseInt(money);
    }

    private void machineMoneyValidation(String money) throws IllegalArgumentException {
        isCorrectAmount(money);
        isDigitString(money);
        isBlank(money);
    }

    private void isDigitString(String money) throws IllegalArgumentException {
        for (char c : money.toCharArray()) {
            isDigit(c);
        }
    }

    private void isDigit(char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자로만 이루어져야 합니다.");
        }
    }

    private void isBlank(String money) throws IllegalArgumentException {
        if (money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값이 비어있습니다.");
        }
    }

    private void isCorrectAmount(String money) throws IllegalArgumentException {
        if (Integer.parseInt(money) % MIN_COIN_UNIT > 0) {
            throw new IllegalArgumentException();
        }
    }
}
