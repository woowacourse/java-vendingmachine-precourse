package vendingmachine.view.output;

import static vendingmachine.view.constant.OutputMessage.RESPONSE_VM_COIN;
import static vendingmachine.view.constant.PrintFormat.*;

import java.util.EnumMap;
import vendingmachine.domain.constant.Coin;

public final class OutputView extends OutputWriter {

    public static void printCoinMap(EnumMap<Coin, Integer> coinMap) {
        System.out.println(RESPONSE_VM_COIN.getMessage());
        // 동전 보유 정보 출력
        coinMap.forEach((coin, count) -> {
            System.out.printf(RESPONSE_CHARGE_COIN.getFormat(), coin.getAmount(), count);
        });
    }

    public static void printPurchaserMoney(int money){
        System.out.printf(RESPONSE_USER_COIN.getFormat(), money);
    }
}
