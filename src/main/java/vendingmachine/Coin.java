package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public static List<Integer> getPossibleAmountList(int money){
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .filter(amount -> amount<= money)
                .collect(Collectors.toList());
    }
    public static Coin findCoinByPrice(int price){
        return Arrays.stream(Coin.values())
                .filter(coin ->price==coin.getAmount())
                .collect(Collectors.toList())
                .get(0);
    }
}
