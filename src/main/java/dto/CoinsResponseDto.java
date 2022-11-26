package dto;

import java.util.EnumMap;
import java.util.HashMap;

import vendingmachine.Coin;

public class CoinsResponseDto {
    private final HashMap<Integer, Integer> coins;

    public CoinsResponseDto(HashMap<Integer, Integer> coins) {
        this.coins = coins;
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }
}
