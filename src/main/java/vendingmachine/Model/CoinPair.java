package vendingmachine.Model;

public class CoinPair {
    private Coin coin;
    private int number;

    public CoinPair(Coin coin, int number) {
        this.coin = coin;
        this.number = number;
    }

    public void addCoinNumber() {
        number++;
    }

    public Coin getCoin() {
        return coin;
    }

    public int getNumber() {
        return number;
    }
}
