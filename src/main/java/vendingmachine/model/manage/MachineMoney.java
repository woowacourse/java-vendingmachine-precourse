package vendingmachine.model.manage;

import java.util.Map;

import vendingmachine.util.Constant;
import vendingmachine.util.ErrorMessage;

public class MachineMoney {
    private final int amount;

    public MachineMoney(String inputMoney) {
        isNumeric(inputMoney);
        this.amount = Integer.parseInt(inputMoney);
        moneyValid(amount);
    }

    public Map<Integer, Integer> toCoins() {
        return Coin.moneyToRandomCoins(amount);
    }

    private void moneyValid(int amount) {
        rangeValid(amount);
        unitSplit(amount);
    }

    private boolean isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            // 에러 출력 로직 필요
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_STRING_ERROR);
        }
        return true;
    }

    private void rangeValid(int amount) {
        if (amount < Constant.UNIT_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_RANGE_ERROR);
        }
    }

    private void unitSplit(int amount) {
        if ((amount % Constant.UNIT_VALUE) != Constant.REST_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_UNIT_ERROR);
        }
    }
}
