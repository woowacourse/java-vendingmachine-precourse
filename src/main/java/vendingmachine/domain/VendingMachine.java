package vendingmachine.domain;

import static vendingmachine.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.utils.CoinGenerator;
import vendingmachine.utils.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private CoinRepository coinRepository;
    private ProductRepository productRepository = new ProductRepository();
    private Price userMoney;

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
            Product product = ProductValidator.validateForm(productInfoInput);
            productRepository.add(product);
        }
        productRepository.showProductRepository();
    }

    public void putUserMoney(String userMoneyInput) {
        userMoney = new Price(userMoneyInput);
        OutputView.showUserMoney(userMoney);
    }

    public void sellProduct(String productName) {
        if (!productRepository.has(productName)) {
            throw new IllegalArgumentException("해당 상품은 존재하지 않습니다.");
        }
        //productRepo 에서 해당 상품을 찾는다.
        // 없으면 에러

        // 있으면 -> 개수가 있나 찾는다.
        // 없으면 에러
    }
}
