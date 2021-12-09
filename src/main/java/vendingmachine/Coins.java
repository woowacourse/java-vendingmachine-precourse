package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Coins {
    private final Map<Coin, Integer> coins = new HashMap<>();

    private Coins(String value) {
        List<Integer> counts = value.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
        for (int i = 0; i < counts.size(); i++) {
            coins.put(Coin.indexOf(i), counts.get(i));
        }
    }

    public static Coins of(String value) {
        return new Coins(value);
    }

    public Integer sum() {
        return coins.entrySet().stream()
            .map(entry -> entry.getKey().calculate(entry.getValue())).reduce(Integer::sum).get();
    }
}
