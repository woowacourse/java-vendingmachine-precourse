package vendingmachine.Model;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public int getAmount() {
        return amount;
    }

    public static Coin getCoin(int amount){
        for(Coin coin : Coin.values()){
            if(coin.getAmount() == amount){
                return coin;
            }
        }
        return null;
    }

    public static List<Integer> getCoinList(){
        List<Integer> coinList = new ArrayList<>();
        for(Coin coin : Coin.values()){
            coinList.add(coin.amount);
        }
        return coinList;
    }
}
