package vendingmachine;

import java.util.EnumMap;
import java.util.HashMap;

import dto.CoinsResponseDto;

public class Coins {
    private EnumMap<Coin, Integer> coins;

    public Coins(EnumMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public CoinsResponseDto toCoinsResponseDto() {
        HashMap<Integer, Integer> coinsToDto = new HashMap<>();
        coins.forEach((coin, integer) -> coinsToDto.put(coin.getAmount(), integer));
        return new CoinsResponseDto(coinsToDto);
    }
}
