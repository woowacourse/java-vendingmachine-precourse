package vendingmachine.domain;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public enum Coin {
    COIN_500(500, value -> value * 500),
    COIN_100(100, value -> value * 100),
    COIN_50(50, value -> value * 50),
    COIN_10(10, value -> value * 10);

    private final int amount;
    private Function<Integer,Integer> calculate;

    Coin(final int amount, Function<Integer,Integer> calculate) {
        this.amount = amount;
        this.calculate= calculate;
    }

    public int calculate(int value){
        return calculate.apply(value);
    }

    public int convertPriceToCoins(Coin coin, int price) {
        int quantity = 0;
        for (int i = 0; i < 4; i++) {
            List<Integer> setPossibleIntList = makePossibleIntList(price / coin.amount);
            quantity = pickNumberInList(setPossibleIntList);
        }
        return quantity;
    }

    private List<Integer> makePossibleIntList(int max){
        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i <= max; i++){
            numList.add(i);
        }
        return numList;
    }

}
