package vendingmachine.model.coin;

import java.util.Map;

public class MachineMoney {
    private static final int UNIT_VALUE = 10;
    private static final int REST_VALUE = 0;
    private static final String MACHINE_MONEY_UNIT_ERROR = "[ERROR] 금액은 10원 단위로 나눠져야 합니다.";
    private static final String MACHINE_MONEY_RANGE_ERROR = "[ERROR] 금액은 10원 이상이어야 합니다.";
    private static final String MACHINE_MONEY_STRING_ERROR = "[ERROR] 금액은 숫자여야 합니다.";

    private final int amount;

    public MachineMoney(String inputMoney) {
        isNumeric(inputMoney);
        this.amount = toInt(inputMoney);
        isValid(amount);
    }

    public Map<Integer, Integer> toCoins() {
        return Coin.moneyToRandomCoins(amount);
    }

    private int toInt(String target) {
        return Integer.parseInt(target);
    }

    private boolean isValid(int amount) {
        if (!isRangeValid(amount)) {
            // 에러 출력 로직 필요
            throw new IllegalArgumentException(MACHINE_MONEY_RANGE_ERROR);
        }
        if (!isUnitSplit(amount)) {
            // 에러 출력 로직 필요
            throw new IllegalArgumentException(MACHINE_MONEY_UNIT_ERROR);
        }
        return true;
    }

    private boolean isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            // 에러 출력 로직 필요
            throw new IllegalArgumentException(MACHINE_MONEY_STRING_ERROR);
        }
        return true;
    }

    private boolean isRangeValid(int amount) {
        return amount >= UNIT_VALUE;
    }

    private boolean isUnitSplit(int amount) {
        return amount % UNIT_VALUE == REST_VALUE;
    }
}
