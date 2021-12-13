package vendingmachine.model.money;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Item.Item;
import vendingmachine.model.Item.Price;
import vendingmachine.model.enums.Coin;

import static vendingmachine.util.validator.Validator.*;

public class MoneyBill {
    private int amount;

    public MoneyBill(int amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    private void validateMoney(int amount) {
        validateNonNegative(amount);
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

    public void add(MoneyBill inputMoney) {
        this.amount += inputMoney.getAmount();
    }

    private int getAmount() {
        return amount;
    }

    public boolean isSameOrBigger(Item item) {
        return this.amount >= item.getPrice().getAmount();
    }

    public boolean isSameOrBigger(MoneyCoin moneyCoin) {
        return this.amount >= moneyCoin.getAmount();
    }

    public void decrease(Price price) {
        this.amount -= price.getAmount();
    }

    public void decrease(MoneyCoin moneyCoin) {
        this.amount -= moneyCoin.getAmount();
    }

    @Override
    public String toString() {
        return Integer.toString(amount);
    }
}
