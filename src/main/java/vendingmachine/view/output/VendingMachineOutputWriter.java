package vendingmachine.view.output;

import static vendingmachine.view.constant.PrintFormat.*;

import java.util.EnumMap;
import vendingmachine.domain.constant.Coin;

public final class VendingMachineOutputWriter extends OutputWriter {

    public static void printCoinMap(EnumMap<Coin, Integer> coinMap) {
        // 동전 보유 정보 출력
        coinMap.forEach((coin, count) -> {
            System.out.printf(RESPONSE_CHARGE_COIN.getFormat(), coin.getAmount(), count);
        });
    }
}
