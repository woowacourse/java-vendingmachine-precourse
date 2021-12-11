package vendingmachine;

import java.util.HashMap;

public class CashManager {
    private int remainCash = 0;
    private HashMap<Coin, Integer> vault;

    public CashManager() {
        this.vault = new HashMap<>();
    }

    public void initVault(int amount) {
        for (Coin coin : Coin.values()) {
            this.vault.put(coin, amount / coin.getAmount());
            amount -= (amount / coin.getAmount()) * coin.getAmount();
        }
    }

    public HashMap<Coin, Integer> getVault() {
        return vault;
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
        if (Integer.MAX_VALUE - amount < this.remainCash) {
            throw new MyIllegalArgumentException(
                    String.format("Cash overflow. Remains: [%d]", this.remainCash)
            );
        }

        remainCash += amount;
    }

    public HashMap<Coin, Integer> getChanges() {
        HashMap<Coin, Integer> ret = new HashMap<>();

        for (Coin coin : Coin.values()) {
            if (this.vault.get(coin) < 1 || this.remainCash < coin.getAmount()) {
                continue;
            }

            this.vault.put(coin, this.vault.get(coin) - this.remainCash / coin.getAmount());
            ret.put(coin, this.remainCash / coin.getAmount());
            this.remainCash -= (this.remainCash / coin.getAmount()) * coin.getAmount();
        }

        return ret;
    }
}
