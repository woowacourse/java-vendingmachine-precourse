package vendingmachine.domain;

import static vendingmachine.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.utils.CoinGenerator;

public class VendingMachine {
    private HashMap<Coin, Integer> coinRepository = new HashMap<>();

    private VendingMachine(int initializeMoney) {
        putInitialAmount(initializeMoney);
    }

    public static VendingMachine makeVendingMachineHasMoney(int initializeMoney) {
        return new VendingMachine(initializeMoney);
    }

    public void putInitialAmount(int inputMoney) {
        if (inputMoney < ZERO) {
            throw new IllegalArgumentException("0 이상의 금액을 입력해주세요.");
        }
        if (inputMoney % MINIMUM_COIN_VALUE != 0) {
            throw new IllegalArgumentException("해당 금액은 동전으로 만들 수 없는 단위의 숫자입니다.");
        }
        coinRepository = CoinGenerator.makeCoins(inputMoney);
        for (Coin coin : coinRepository.keySet()) {
            System.out.println(coin + ": " + coinRepository.get(coin));
        }
    }
}
