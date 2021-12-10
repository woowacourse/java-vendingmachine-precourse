package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.utils.CoinGenerator;
import vendingmachine.utils.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private CoinRepository coinRepository;
    private ProductRepository productRepository = new ProductRepository();
    private Price userMoney;

    private VendingMachineController(int initializeMoney) {
        putInitialAmount(initializeMoney);
    }

    public static VendingMachineController makeVendingMachineHasMoney(int initializeMoney) {
        return new VendingMachineController(initializeMoney);
    }

    public void putInitialAmount(int inputMoney) { //금액 검증 로직 만들었으니 그걸 사용하기.
        if (inputMoney < ZERO) {
            throw new IllegalArgumentException("0 이상의 금액을 입력해주세요.");
        }
        if (inputMoney % MINIMUM_COIN_VALUE != 0) {
            throw new IllegalArgumentException("해당 금액은 동전으로 만들 수 없는 단위의 숫자입니다.");
        }
        coinRepository = new CoinRepository(CoinGenerator.makeCoins(inputMoney));
        // System.out.println(coinRepository);
        OutputView.showAllCoinsMachineHave(coinRepository);

    }

    public void putProducts(ArrayList<String> productsInfo) {
        productRepository.clear();
        for (String productInfoInput : productsInfo) {
            Product product = ProductValidator.validateForm(productInfoInput);
            productRepository.add(product);
        }
        if (productRepository.hasNoQuantity()) {
            throw new IllegalArgumentException("자판기에는 최소 한 개의 물건은 들어가야 합니다.");
        }
        // productRepository.showProductRepository();
    }

    public void putUserMoney(String userMoneyInput) {
        userMoney = new Price(userMoneyInput);
        if (productRepository.cantBuyBecauseOfNoMoney(userMoney)) {
            throw new IllegalArgumentException("투입한 금액으로 살 수 있는 물건은 존재하지 않습니다.");
        }
        OutputView.showUserMoney(userMoney);
    }

    public boolean sellProduct(String productName) {
        if (!productRepository.has(productName)) {
            throw new IllegalArgumentException("해당 상품은 존재하지 않습니다.");
        }
        int productPrice = productRepository.takeout(productName);
        userMoney.use(productPrice);
        OutputView.showUserMoney(userMoney);
        if (productRepository.cantBuyBecauseOfNoMoney(userMoney) || productRepository.hasNoQuantity()) {
            return false;
        }
        return true;
    }

    public void giveChange() {
        OutputView.showChange(coinRepository.giveChange(userMoney));
    }
}
