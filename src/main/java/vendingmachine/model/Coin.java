package vendingmachine.model;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int num;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
}
