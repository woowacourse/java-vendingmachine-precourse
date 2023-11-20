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

//    public void purchaseProduct(String product) {
//        product
//    }
}

