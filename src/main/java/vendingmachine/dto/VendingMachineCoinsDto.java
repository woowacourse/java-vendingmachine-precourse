package vendingmachine.dto;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineCoins;

import java.util.EnumMap;

public class VendingMachineCoinsDto {
    private final EnumMap<Coin, Long> coins;

    private VendingMachineCoinsDto(EnumMap<Coin, Long> coins) {
        this.coins = coins;
    }

    public static VendingMachineCoinsDto from(VendingMachineCoins coins) {
        EnumMap<Coin, Long> providedCoins = coins.provideCoins();
        return new VendingMachineCoinsDto(providedCoins);
    }

    public EnumMap<Coin, Long> getCoins() {
        return coins;
    }
}
