package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;

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
        while (amount > 0) {
            Coin coin = pickRandomCoin();
            if (amount - coin.getAmount() < 0) {
                continue;
            }
            Change change = changes.stream().filter(c -> c.getCoin() == coin).findAny().get();
            change.increaseNumber();
            amount -= coin.getAmount();
        }
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

    private Coin pickRandomCoin() {
        List<Integer> ranges = Coin.getCoinValues();
        int number = Randoms.pickNumberInList(ranges);
        return Coin.valueOf(Symbol.COIN + number);
    }
}
