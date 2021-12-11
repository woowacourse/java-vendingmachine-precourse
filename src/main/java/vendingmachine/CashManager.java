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

    public String getVaultStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("자판기가 보유한 동전").append(System.lineSeparator());

        for (Coin coin : Coin.values()) {
            sb.append(coin.getAmount()).append("원 - ");
            sb.append(this.vault.get(coin)).append("개").append(System.lineSeparator());
        }

        return sb.toString();
    }

    public int getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(int remainCash) {
        this.remainCash = remainCash;
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

    public CashManager getChanges() {
        HashMap<Coin, Integer> coins = new HashMap<>();

        for (Coin coin : Coin.values()) {
            if (this.vault.get(coin) < 1 || this.remainCash < coin.getAmount()) {
                continue;
            }

            this.vault.put(coin, this.vault.get(coin) - this.remainCash / coin.getAmount());
            coins.put(coin, this.remainCash / coin.getAmount());
            this.remainCash -= (this.remainCash / coin.getAmount()) * coin.getAmount();
        }

        CashManager ret = new CashManager();
        ret.vault = coins;
        return ret;
    }
}
