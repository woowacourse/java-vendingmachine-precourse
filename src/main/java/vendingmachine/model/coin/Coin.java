package vendingmachine.model.coin;

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

    public static List<Integer> coinTypes(){
        List<Integer> types = new ArrayList<>();
        Arrays.stream(Coin.values())
                .forEach(coin -> types.add(coin.amount));
        return types;
    }

    public static Coin getCoinType(int amount){
        return Coin.valueOf("COIN_" + amount);
    }
}
