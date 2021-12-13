package vendingmachine.model;

import vendingmachine.util.constant.InputCondition;
import vendingmachine.util.constant.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Changes {
    private final List<Change> changes;

    public Changes() {
        this.changes = initChanges();
    }

    public List<Change> getChanges() {
        return changes;
    }

    @Override
    public String toString() {
        return changes.stream()
                .map(Change::toString)
                .collect(Collectors.joining(Symbol.NEW_LINE));
    }

    public void calculateChanges(int amount) {
        while (amount >= Coin.COIN_50.getAmount()) {
            amount = updateChangesByRandom(amount);
        }
        dealWithRemainAmount(amount);
    }

    public int getSumOfChanges() {
        int sum = 0;

        for (Change change : changes) {
            if (change.getNumber() == 0) {
                continue;
            }
            sum += change.getNumber() * change.getCoin().getAmount();
        }
        return sum;
    }

    public List<Change> calculateReturnChanges(int amount) {
        List<Change> returnChanges = new ArrayList<>();

        for (Change change : changes) {
            if (amount <= 0) {
                break;
            }
            Change returnChange = change.getReturnChange(amount);
            returnChanges.add(returnChange);
            amount -= returnChange.getNumber() * returnChange.getCoin().getAmount();
        }
        return returnChanges;
    }

    private List<Change> initChanges() {
        List<Change> changes = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            Change change = new Change(coin);
            changes.add(change);
        }
        return changes;
    }

    private int updateChangesByRandom(int amount) {
        for (Change change : changes) {
            Coin coin = change.getCoin();
            if (amount < coin.getAmount()) {
                continue;
            }
            int number = change.pickRandomNumber(amount);
            change.addNumber(number);
            amount -= coin.getAmount() * number;
        }
        return amount;
    }

    private void dealWithRemainAmount(int amount) {
        Change change = changes.get(changes.size() - 1);
        change.addNumber(amount / InputCondition.AMOUNT_UNIT);
    }
}
