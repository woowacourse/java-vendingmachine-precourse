package vendingmachine;

import java.util.EnumMap;
import java.util.Map;

public class VendingMachine {
    private ProductStore productStore;
    private CoinStore coinStore;
    private int holdingMoney;

    public VendingMachine() {
        productStore = new ProductStore();
        coinStore = new CoinStore(new EnumMap<>(Coin.class));
        holdingMoney = 0;
    }

    public void initProducts(ProductStore repository) {
        this.productStore = repository;
    }

    public void initMoney(int money) {
        validateMoney(money);
        coinStore.addCoinRandomly(money);
    }

    public boolean canPurchaseSomething() {
        return productStore.canBuySomething(holdingMoney);
    }

    public void initInputMoney(int inputMoney) {
        validateMoney(inputMoney);
        holdingMoney = inputMoney;
    }

    private static void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public void purchaseProduct(String productName) {
        Product product = productStore.findProductByName(productName);
        validatePurchase(product);
        productStore.purchaseProduct(product);
        holdingMoney -= product.getPrice();
    }

    private void validatePurchase(Product product) {
        if (product.getPrice() > holdingMoney) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        if (productStore.getLeftProductCount(product) <= 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
    }

    public int getHoldingMoney() {
        return holdingMoney;
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinStore.getRepository();
    }

    public Map<Coin, Integer> getChange() {
        return coinStore.getChange(holdingMoney);
    }
}

