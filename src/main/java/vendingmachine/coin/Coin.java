package vendingmachine.coin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

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

    public boolean isSameAmount(int price){
        return amount==price;
    }

    public boolean lessThanEqual(int price){
        return amount<=price;
    }

    public static List<Coin> sortedCoins(){
        return Arrays.stream(Coin.values())
            .sorted(Comparator.comparingInt(Coin::getAmount).reversed())
            .collect(Collectors.toList());
    }
}
