package vendingmachine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import dto.CoinsResponseDto;

public class Coins {
    private final EnumMap<Coin, Integer> coins;

    public Coins(EnumMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public CoinsResponseDto toCoinsResponseDto() {
        HashMap<Integer, Integer> coinsToDto = new HashMap<>();
        coins.forEach((coin, integer) -> coinsToDto.put(coin.getAmount(), integer));
        return new CoinsResponseDto(coinsToDto);
    }

    public CoinsResponseDto calculateChanges(int money) {
        EnumMap<Coin, Integer> change = new EnumMap<>(Coin.class);
        List<Coin> coins = makeCoins(change);
        for (Coin coin : coins) {
            int portion = Math.min(this.coins.get(coin), money / coin.getAmount());
            if (portion != 0) {
                change.put(coin, portion);
            }
            money -= coin.getAmount() * portion;
        }
       return changeToDto(change);
    }

    private CoinsResponseDto changeToDto(EnumMap<Coin, Integer> change) {
        HashMap<Integer, Integer> coinsToDto = new HashMap<>();
        change.forEach((coin, integer) -> coinsToDto.put(coin.getAmount(), integer));
        return new CoinsResponseDto(coinsToDto);
    }

    private List<Coin> makeCoins(EnumMap<Coin, Integer> change) {
        return Arrays.stream(Coin.values())
            .sorted((coin1, coin2) -> coin2.getAmount() - coin1.getAmount())
            .collect(Collectors.toList());
    }
}
