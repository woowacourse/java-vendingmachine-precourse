package vendingmachine.Service;

import vendingmachine.Domain.Coin;
import vendingmachine.Domain.Coins;
import vendingmachine.Domain.InputAmount;

public class ChangeService {
    public void calculateChange() {
        for (Coin c : Coin.values()) {
            int count = Coins.calculateNumberOfCoin(c);
            if (count > 0) {
                InputAmount.takeMoney(c.calculateTotalAmount(count));
                Coins.addToChange(c, count);
            }
        }
    }
}
