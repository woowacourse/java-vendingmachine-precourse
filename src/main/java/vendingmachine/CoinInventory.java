package vendingmachine;

public enum CoinInventory {
    COIN_500(0),
    COIN_100(0),
    COIN_50(0),
    COIN10(0);

    private int stock;

    CoinInventory(int stock) {
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }
}
