package vendingmachine;

import java.util.EnumMap;
import java.util.Map;

public class VendingMachine {
    private ProductRepository repository;
    private Map<Coin, Integer> coinMap;
    private int holdingMoney;

    public VendingMachine() {
        repository = new ProductRepository();
        coinMap = new EnumMap<>(Coin.class);
        holdingMoney = 0;
    }

    public void initProducts(ProductRepository repository) {
        this.repository = repository;
    }

    public void initMoney(int money) {
        validateMoney(money);
        while (money >= Coin.COIN_10.getAmount()) {
            Coin pickedCoin = Coin.getRandomCoin();
            if (money < pickedCoin.getAmount()) {
                continue;
            }
            money -= pickedCoin.getAmount();
            coinMap.put(pickedCoin, coinMap.getOrDefault(pickedCoin, 0) + 1);
        }
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }

    public boolean canPurchaseSomething() {
        return repository.canBuySomething(holdingMoney);
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
        Product product = repository.findProductByName(productName);
        validatePurchase(product);
        repository.purchaseProduct(product);
        holdingMoney -= product.getPrice();
    }

    private void validatePurchase(Product product) {
        if (product.getPrice() > holdingMoney) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        if (repository.getLeftProductCount(product) <= 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
    }

    public int getHoldingMoney() {
        return holdingMoney;
    }

    public Map<Coin, Integer> getChange() {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        Coin.getCoinOrderedList()
                .forEach((coin) -> handleChange(change, coin));
        return change;
    }

    private void handleChange(Map<Coin, Integer> change, Coin coin) {
        if (coinMap.get(coin) == null || coinMap.get(coin) <= 0) {
            return;
        }
        if (holdingMoney >= coin.getAmount()) {
            int quantity = Math.min(holdingMoney / coin.getAmount(), coinMap.get(coin));
            change.put(coin, quantity);
            holdingMoney -= coin.getAmount() * quantity;
        }
    }
}

