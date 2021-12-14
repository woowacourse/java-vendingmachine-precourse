package vendingmachine.domain.possessionmoney;

public class PossessionMoney {
    private static final int ZERO = 0;
    private static final int QUOTIENT = 10;

    private static final String VALID_NUMBER_FORMAT = "[ERROR] 보유 금액은 숫자여야 합니다.";
    private static final String VALID_NEGATIVE_NUMBER = "[ERROR] 보유 금액은 음수가 될 수 없습니다.";
    private static final String VALID_DIVIDE = "[ERROR] 보유 금액은 10으로 나누어 떨어져야 합니다.";

    private int possessionMoney;

    public PossessionMoney(String inputPossessionMoney) {
        validateNumberFormat(inputPossessionMoney);
        int possessionMoney = Integer.parseInt(inputPossessionMoney);

        validateNegativeNumber(possessionMoney);
        validateDivide(possessionMoney);
        this.possessionMoney = possessionMoney;
    }

    private void validateNumberFormat(String inputPossessionMoney) {
        try {
            Integer.parseInt(inputPossessionMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateNegativeNumber(int possessionMoney) {
        if (possessionMoney < ZERO) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER);
        }
    }

    private void validateDivide(int possessionMoney) {
        if (possessionMoney % QUOTIENT != ZERO) {
            throw new IllegalArgumentException(VALID_DIVIDE);
        }
    }

    public boolean isExist() {
        return possessionMoney > ZERO;
    }

    public boolean isCalculate(int amount) {
        return possessionMoney >= amount;
    }

    public void calculate(int randomCoinAmount) {
        possessionMoney -= randomCoinAmount;
    }
}