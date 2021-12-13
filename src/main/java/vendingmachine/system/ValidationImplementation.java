package vendingmachine.system;

public class ValidationImplementation implements Validation {

    private static final int MINIMUM_HOLDING_MONEY = 100;
    private static final int HOLDING_MONEY_LIMITED_LENGTH = 9;

    public boolean isValidHoldingMoney(String holdingMoney) {
        boolean result = true;
        result = isCharacter(holdingMoney);
        result = isLessThan100MillionOrLessThan100(holdingMoney);
        result = isDivisibleBy10(holdingMoney);
        return result;
    }

    private boolean isCharacter(String holdingMoney) {
        boolean result = true;
        for (int currentIndex = 0; currentIndex < holdingMoney.length(); currentIndex++) {
            if (!isDigit(holdingMoney.charAt(currentIndex))) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    private boolean isLessThan100MillionOrLessThan100(String holdingMoney) {
        boolean result = true;
        if (holdingMoney.length() > HOLDING_MONEY_LIMITED_LENGTH
            || Integer.parseInt(holdingMoney) < MINIMUM_HOLDING_MONEY) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private boolean isDigit(char holdingMoneyCharacter) {
        return Character.isDigit(holdingMoneyCharacter);
    }

    private boolean isDivisibleBy10(String holdingMoney) {
        if (Integer.parseInt(holdingMoney) % 10 != 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
