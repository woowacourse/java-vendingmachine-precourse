package vendingmachine.domain;

public class PossessionMoney {
    private static final int ZERO = 0;
    private static final int QUOTIENT = 10;

    private final int possessionMoney;

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
            throw new IllegalArgumentException();
        }
    }

    private void validateNegativeNumber(int possessionMoney) {
        if (possessionMoney < ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int possessionMoney) {
        if (possessionMoney % QUOTIENT != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}