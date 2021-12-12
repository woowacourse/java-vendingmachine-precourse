package vendingmachine.model;

public class Change {
    private final Coin coin;
    private int number;

    public Change(Coin coin, int price) {
        this.coin = coin;
        this.number = pickRandomNumber(price);
    }

    private int pickRandomNumber(int price) {
        // TODO: 랜덤 수 반환
        return 0;
    }
}
