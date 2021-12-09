package vendingmachine.domain;

import static vendingmachine.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.repository.CoinRepository;
import vendingmachine.utils.CoinGenerator;
import vendingmachine.utils.ProductValidator;

public class VendingMachine {
    private CoinRepository coinRepository;

    private VendingMachine(int initializeMoney) {
        putInitialAmount(initializeMoney);
    }

    public static VendingMachine makeVendingMachineHasMoney(int initializeMoney) {
        return new VendingMachine(initializeMoney);
    }

    public void putInitialAmount(int inputMoney) { //금액 검증 로직 만들었으니 그걸 사용하기.
        if (inputMoney < ZERO) {
            throw new IllegalArgumentException("0 이상의 금액을 입력해주세요.");
        }
        if (inputMoney % MINIMUM_COIN_VALUE != 0) {
            throw new IllegalArgumentException("해당 금액은 동전으로 만들 수 없는 단위의 숫자입니다.");
        }
        coinRepository = new CoinRepository(CoinGenerator.makeCoins(inputMoney));
        System.out.println(coinRepository);
    }

    public void putProducts(ArrayList<String> productsInfo) {
        for (String productInfoInput : productsInfo) {
            // [콜라,1500,20]  //productInfo를 진짜 product에 넣어서 검증한다.
            ProductValidator.validateForm(productInfoInput);
            System.out.println(productInfoInput);
        }

    }
}
