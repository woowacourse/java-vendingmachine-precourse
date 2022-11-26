package dto;

import java.util.EnumMap;
import java.util.HashMap;

import vendingmachine.Coin;

public class CoinsResponseDto {
    private final EnumMap<Coin, Integer> coins;

    public CoinsResponseDto(EnumMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public EnumMap<Coin, Integer> getCoins() {
        return coins;
    }
}
