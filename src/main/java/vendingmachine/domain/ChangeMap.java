package vendingmachine.domain;

import vendingmachine.utils.CommonConstant;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeMap {
    private final Map<Coin, Integer> changes = new LinkedHashMap<>();

    public void updateValue(Coin coin, int amount) {
        changes.put(coin, amount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Coin coin: changes.keySet()) {
            stringBuilder.append(coin)
                    .append(CommonConstant.CONNECTION_MARK)
                    .append(changes.get(coin))
                    .append(CommonConstant.COINS_POSTFIX);
        }
        return stringBuilder.toString();
    }
}
