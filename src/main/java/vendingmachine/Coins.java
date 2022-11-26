package vendingmachine;

import java.util.EnumMap;

import dto.CoinsResponseDto;

public class Coins {
    private EnumMap<Coin, Integer> coins;

    public Coins(EnumMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public CoinsResponseDto toCoinsResponseDto() {
        return new CoinsResponseDto(coins);
    }
}
