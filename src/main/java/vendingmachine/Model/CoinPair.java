package vendingmachine.Model;

public class CoinPair {
    private static String name;
    private static int number;

    public CoinPair(Coin coin, int number){
        this.name=coin.name();
        this.number=number;
    }

    public static String getName(){
        return name;
    }
    public static int getNumber(){
        return number;
    }
}
