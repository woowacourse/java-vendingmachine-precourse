package vendingmachine;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.message.ExceptionMessage;

public class VendingMachine {
    private ProductStore productStore;
    private CoinStore coinStore;
    private Money holdingMoney;

    public VendingMachine() {
        productStore = new ProductStore();
        coinStore = new CoinStore(new EnumMap<>(Coin.class));
        holdingMoney = new Money(0);
    }

    public void initProducts(ProductStore repository) {
        this.productStore = repository;
    }

    public void initHoldingMoney(Money money) {
        coinStore.addCoinRandomly(money);
    }

    public boolean canPurchaseSomething() {
        return productStore.canBuySomething(holdingMoney.getAmount());
    }

    public void initInputMoney(Money inputMoney) {
        holdingMoney = inputMoney;
    }


    public void purchaseProduct(String productName) {
        Product product = productStore.findProductByName(productName);
        validatePurchase(product);
        productStore.purchaseProduct(product);
        holdingMoney.minus(product.getPrice());
    }

    private void validatePurchase(Product product) {
        if (holdingMoney.isLessThen(product.getPrice())) {
            throw new IllegalArgumentException(ExceptionMessage.LACK_MONEY);
        }
        if (productStore.getLeftProductCount(product) <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.LACK_QUANTITY);
        }
    }

    public Money getHoldingMoney() {
        return holdingMoney;
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinStore.getRepository();
    }

    public Map<Coin, Integer> getChange() {
        return coinStore.getChange(holdingMoney);
    }
}

