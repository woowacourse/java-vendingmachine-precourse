package vendingmachine.Model;

public class CoinPair {
    private String name;
    private int number;

    public CoinPair(Coin coin, int number){
        this.name=coin.name();
        this.number=number;
    }

    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
}
