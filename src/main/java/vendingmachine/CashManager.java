package vendingmachine;

import java.util.HashMap;

public class CashManager {
    private int remainCash = 0;
    private HashMap<Coin, Integer> vault;

    public CashManager(int amount) {
        this.vault = getMinimumCoins(amount);
    }

    public int getRemainCash() {
        return remainCash;
    }

    public void withdraw(int amount) throws MyIllegalArgumentException {
        if (remainCash < amount) {
            throw new MyIllegalArgumentException(
                    String.format("Not enough remain cash. Remains: [%d]", this.remainCash)
            );
        }

        remainCash -= amount;
    }

    public void deposit(int amount) throws MyIllegalArgumentException {
        if(Integer.MAX_VALUE - amount < this.remainCash) {
            throw new MyIllegalArgumentException(
                    String.format("Cash overflow. Remains: [%d]", this.remainCash)
            );
        }

        remainCash += amount;
    }


    private HashMap<Coin, Integer> getMinimumCoins(int amount) {
        HashMap<Coin, Integer> ret = new HashMap<>();

        for (Coin coin : Coin.values()) {
            ret.put(coin, amount / coin.getAmount());
            amount -= (amount / coin.getAmount()) * coin.getAmount();
        }

        return ret;
    }
}
