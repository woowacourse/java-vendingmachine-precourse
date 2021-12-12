package vendingmachine.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, 0, value -> value / 500),
    COIN_100(100, 1, value -> value/ 100),
    COIN_50(50,2, value -> value/ 50),
    COIN_10(10, 3, value -> value / 10);

    private final int amount;
    private final int index;
    private Function<Integer,Integer> calculateChange;


    Coin(final int amount, int index, Function<Integer, Integer> calculateChange) {
        this.amount = amount;
        this.index = index;
        this.calculateChange = calculateChange;
    }

    public static boolean isPossible(int amount,Coin coin){
        if(amount >= coin.amount){
            return true;
        }
        return false;
    }


    public static List<Integer> convertAmountList(List<Coin> possibleCoinList){
        return possibleCoinList.stream()
                .map(coin-> coin.amount)
                .collect(Collectors.toList());
    }


    public int multiply(int value){
        return this.amount * value;
    }

    public int calculateChange(int value){return calculateChange.apply(value);}

}
