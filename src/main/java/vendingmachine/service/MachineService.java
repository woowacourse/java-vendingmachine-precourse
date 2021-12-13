package vendingmachine.service;

import vendingmachine.model.Coin;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.repository.MachineRepository;
import vendingmachine.repository.ProductsRepository;

import java.util.Map;

public class MachineService {
    private static final int DEFAULT_VALUE = 0;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String PRODUCT_NOT_EXIST = "존재하지 않는 상품명입니다";
    private static final String NOT_ENOUGH_QUANTITY_MESSAGE = "상품 수량이 부족합니다.";
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "잔액이 부족합니다.";
    private static final String TRY_AGAIN_MESSAGE = " 다시 선택해 주세요.";

    public void saveAmount(String amount) {
        MachineRepository.saveInitialAmount(amount);
    }

    public void saveProducts(String inputProducts) {
        ProductsRepository.createProducts(inputProducts);
        Products products = ProductsRepository.getProducts();
        MachineRepository.saveProducts(products);
    }

    public void saveUserInsertAmount(String userAmount) {
        MachineRepository.saveUserInsertAmount(userAmount);
    }

    public void buyProduct(String productName) {
        checkProductName(productName);
        checkProductQuantity(productName);
        checkUserAmount(productName);
        ProductsRepository.popProduct(productName);
        int productPrice = ProductsRepository.findProductByName(productName).getPrice();
        MachineRepository.reduceUserAmount(productPrice);
    }

    private void checkProductName(String productName) {
        if (!ProductsRepository.hasProduct(productName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + PRODUCT_NOT_EXIST + RETRY_MESSAGE);
        }
    }
    private void checkProductQuantity(String productName) {
        if (!ProductsRepository.checkProductQuantity(productName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_ENOUGH_QUANTITY_MESSAGE + RETRY_MESSAGE);
        }
    }

    private void checkUserAmount(String productName) {
        int userAmount = MachineRepository.getUserInsertAmount();
        int productPrice = ProductsRepository.getProductPrice(productName);
        if (userAmount < productPrice) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_ENOUGH_MONEY_MESSAGE + TRY_AGAIN_MESSAGE);
        }
    }

    public Map<Coin, Integer> getCoins() {
        return MachineRepository.getCoins();
    }

    public int getUserInsertAmount() {
        return MachineRepository.getUserInsertAmount();
    }

    public boolean shouldContinue() {
        return hasEnoughInsertAmount() && hasRemainingProducts() && canBuySomething();
    }

    private boolean hasEnoughInsertAmount() {
        return MachineRepository.getUserInsertAmount() >= ProductsRepository.getCheapest();
    }

    private boolean hasRemainingProducts() {
        return ProductsRepository.hasAnyProducts();
    }

    private boolean canBuySomething() {
        int amount = MachineRepository.getUserInsertAmount();
        return ProductsRepository.existProductToBuy(amount) > DEFAULT_VALUE;
    }

    public Map<Coin, Integer> getChanges() {
        return MachineRepository.getChanges();
    }
}
