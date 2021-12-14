package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
    public int getValue(){return amount;};

    public static List<Integer> getCoinList (){
        List<Integer> coins = new ArrayList<Integer>();
        for(Coin coin : Coin.values()){
            coins.add(coin.getValue());
        }
        return coins;
    }

    public Integer getAmount(){
        return this.amount;
    }

}
