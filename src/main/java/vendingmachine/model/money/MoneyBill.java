package vendingmachine.model.money;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.enums.Coin;

import static vendingmachine.util.Validator.*;

public class MoneyBill {
    private int amount;

    public MoneyBill(int amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    private void validateMoney(int amount) {
        try {
            validateNonNegative(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isZero() {
        return this.amount == 0;
    }

    public boolean isSmallerThan(int amount) {
        return this.amount < amount;
    }

    public MoneyCoin convertToRandomCoin() {
        int randomAmount = Randoms.pickNumberInList(Coin.getValuesList());
        while (this.isSmallerThan(randomAmount)) {
            randomAmount = Randoms.pickNumberInList(Coin.getValuesList());
        }
        this.amount -= randomAmount;
        return new MoneyCoin(randomAmount);
    }
}
