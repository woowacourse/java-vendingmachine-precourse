package vendingmachine.domain;

import static vendingmachine.Constant.*;

public class VendingMachine {
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
        // ArrayList<Coin, Integer> coinRepository = CoinGenerator.makeCoins(inputMoney);
    }
    //금액을 입력받는다
    //금액이 100원 이상 10으로 나눠떨어지는거여야 한다.
}
