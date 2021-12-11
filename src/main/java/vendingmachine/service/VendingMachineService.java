package vendingmachine.service;

import static vendingmachine.ErrorMessage.*;

import java.util.ArrayList;

import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineChecker;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.utils.CoinGenerator;
import vendingmachine.utils.ProductValidator;
import vendingmachine.view.OutputView;

public class VendingMachineService {
    private CoinRepository coinRepository;
    private ProductRepository productRepository = new ProductRepository();
    private Price userMoney;

    private VendingMachineService(int initializeMoney) {
        putInitialAmount(initializeMoney);
    }

    public static VendingMachineService makeVendingMachineHasMoney(int initializeMoney) {
        return new VendingMachineService(initializeMoney);
    }

    public void putInitialAmount(int inputMoney) {
        coinRepository = new CoinRepository(CoinGenerator.makeCoins(new Price(inputMoney)));
        OutputView.showAllCoinsMachineHave(coinRepository);

    }

    public void putProducts(ArrayList<String> productsInfo) {
        productRepository.clear();
        for (String productInfoInput : productsInfo) {
            Product product = ProductValidator.validateForm(productInfoInput);
            productRepository.add(product);
        }
        if (productRepository.hasNoQuantity()) {
            throw new IllegalArgumentException(VENDING_MACHINE_NO_INITIAL_ERROR_MESSAGE);
        }
    }

    public void putUserMoney(String userMoneyInput) {
        userMoney = new Price(userMoneyInput);
        if (!productRepository.canBuyProduct(userMoney)) {
            throw new IllegalArgumentException(MONEY_LACK_ERROR_MESSAGE);
        }
        OutputView.showUserMoney(userMoney);
    }

    public VendingMachineChecker sellProduct(String productName) {
        validateProductExist(productName);
        int productPrice = productRepository.takeout(productName,userMoney);
        userMoney.use(productPrice);
        OutputView.showUserMoney(userMoney);
        return isContinue();
    }

    public VendingMachineChecker isContinue() {
        if (!productRepository.canBuyProduct(userMoney) || productRepository.hasNoQuantity()) {
            return VendingMachineChecker.END;
        }
        // 가지고 있는 금액으로 살 수 있는 물건이 한 개도 없다. - > end
        return VendingMachineChecker.START;
    }

    private void validateProductExist(String productName) {
        if (!productRepository.has(productName)) {
            throw new IllegalArgumentException(NO_PRODUCT_ERROR_MESSAGE);
        }
    }

    public void giveChange() {
        OutputView.showChange(coinRepository.giveChange(userMoney));
    }

}
