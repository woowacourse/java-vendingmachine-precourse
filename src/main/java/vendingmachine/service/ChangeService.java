package vendingmachine.service;

import vendingmachine.domain.Change;
import vendingmachine.domain.Money;

public class ChangeService {

    public Change crateChange(Money money) {
        Change change = new Change(money.getPrice());

        change.createCoin();

        return change;
    }
}
