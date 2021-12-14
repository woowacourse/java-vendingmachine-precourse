package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {

    Map<Coin, Integer> coinBox;
    List<Product> products;
    Speaker speaker;
    Touchpad touchpad;
    Assistant assistant;

    public VendingMachine() {
        this.coinBox = new LinkedHashMap<>();
        this.speaker = new Speaker();
        this.touchpad = new Touchpad();
        this.assistant = new Assistant();
        List<Coin> sortedCoins = makeCoinStream().sorted().collect(Collectors.toList());
        for (Coin coin : sortedCoins) {
            coinBox.put(coin, 0);
        }
    }

    public void setBaseAsset() {
        speaker.requestVendingMachineAsset();
        String rawAsset = touchpad.insertVendingMachineAsset();
        try {
            int asset = assistant.convertToInteger(rawAsset);
            assistant.checkMoney(asset);
            generateRandomCoinBasedOnAsset(asset);
            speaker.announceCoinStock(coinBox);
        } catch (IllegalArgumentException e) {
            speaker.announceError(e.getMessage());
            setBaseAsset();
        }
    }

    public void setProducts() {
        products = new ArrayList<>();
        speaker.requestProducts();
        String rawProducts = touchpad.inputProducts();
        try {
            products = assistant.collectProducts(rawProducts);
        } catch (IllegalArgumentException e) {
            speaker.announceError(e.getMessage());
            setProducts();
        }
    }

    public void sellProducts() {
        speaker.announceInsertMoney();
        String rawInsertedMoney = touchpad.insertMoney();
        Integer insertedMoney = assistant.convertToInteger(rawInsertedMoney);
        assistant.checkMoney(insertedMoney);
        while (true) {
            speaker.announceBalance(insertedMoney);
            if (!purchasePossible(insertedMoney)) {
                stopSale(insertedMoney);
                break;
            }
            insertedMoney -= purchaseProduct();
        }
    }

    private void stopSale(Integer insertedMoney) {
        speaker.announceChanges();
        changeMoney(insertedMoney);
    }

    private Integer purchaseProduct() {
        speaker.requestPurchaseProduct();
        String wantedProduct = touchpad.purchaseProduct();
        return sellProduct(wantedProduct);
    }

    private void generateRandomCoinBasedOnAsset(int asset) {
        List<Integer> coins = makeCoinStream().map(Coin::getAmount).collect(Collectors.toList());
        while (asset > 0) {
            int randomCoin = Randoms.pickNumberInList(coins);
            if (isAvailableCoin(asset, randomCoin)) {
                asset -= randomCoin;
                Coin generatedCoin = assistant.findCoin(randomCoin);
                insertGeneratedCoinToCoinBox(generatedCoin);
            }
        }
    }

    private void insertGeneratedCoinToCoinBox(Coin generatedCoin) {
        coinBox.put(generatedCoin, addOneCoin(generatedCoin));
    }

    private int addOneCoin(Coin generatedCoin) {
        return coinBox.get(generatedCoin) + 1;
    }

    private boolean isAvailableCoin(int asset, int randomCoin) {
        return asset >= randomCoin;
    }

    private boolean purchasePossible(int insertedMoney) {
        if (minPrice() > insertedMoney) {
            return false;
        }
        if (allSoldOut()) {
            return false;
        }
        return true;
    }

    private int minPrice() {
        List<Integer> integerStream = products.stream().map(Product::getPrice).collect(Collectors.toList());
        return Collections.min(integerStream);
    }

    private boolean allSoldOut() {
        return products.stream().filter(Product::soldOut).count() == products.size();
    }

    private void changeMoney(int insertedMoney) {
        Set<Coin> coins = coinBox.keySet();
        for (Coin coin : coins) {
            Integer coinCount = coinBox.get(coin);
            coinCount = coin.calculateMaxCoinCount(insertedMoney, coinCount);
            insertedMoney -= coin.calculateTotalAmount(coinCount);
            speaker.announceCoinAmount(coin, coinCount);
        }
    }

    private int sellProduct(String wantedProduct) {
        try {
            Product soldProduct = assistant.findWantedProduct(products, wantedProduct);
            soldProduct.sell();
            return soldProduct.getPrice();
        } catch (IllegalArgumentException e) {
            speaker.announceError(e.getMessage());
            return 0;
        }
    }

    private Stream<Coin> makeCoinStream() {
        return Arrays.stream(Coin.values());
    }
}
