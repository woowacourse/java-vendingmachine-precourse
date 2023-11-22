package vendingmachine.dto;

import vendingmachine.domain.Coin;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExchangeCoinsDto {
    private final Map<Integer, Long> coins;

    private ExchangeCoinsDto(Map<Integer, Long> coins) {
        this.coins = coins;
    }

    public static ExchangeCoinsDto from(EnumMap<Coin, Long> exchangeCoins) {
        Map<Integer, Long> coins = exchangeCoins.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getAmount(),
                        Map.Entry::getValue
                ));
        return new ExchangeCoinsDto(coins);
    }

    public Map<Integer, Long> getCoins() {
        return coins;
    }
}