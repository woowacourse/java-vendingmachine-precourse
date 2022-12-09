package vendingmachine;

import static Constants.CommonValues.FALSE;
import static Constants.CommonValues.MINIMUM_COIN_VALUE;

import Constants.Coin;
import UI.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<Coin, Integer> coinBox;
    private List<Product> productShelf;

    public VendingMachine() {
        InputView inputView = new InputView();
        coinBox = fillCoins(inputView.askVendingMachineMoney());
        productShelf = fillProducts(inputView.askProductsInfo());
    }

    private Map<Coin, Integer> fillCoins(int vendingMachineMoney) {
        Map<Coin, Integer> coinBox = new HashMap<>();
        distributeMoney(vendingMachineMoney, coinBox);
        return coinBox;
    }

    private static void distributeMoney(int vendingMachineMoney, Map<Coin, Integer> coinBox) {
        int coinSize;
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == MINIMUM_COIN_VALUE) {
                coinSize = vendingMachineMoney / MINIMUM_COIN_VALUE;
                coinBox.put(coin, coinSize);
                break;
            }
            coinSize = Randoms.pickNumberInRange(0, vendingMachineMoney / coin.getAmount());
            vendingMachineMoney -= coin.getAmount() * coinSize;
            coinBox.put(coin, coinSize);
        }
    }

    private List<Product> fillProducts(List<String> productsInfo) {
        List<Product> productShelf = new ArrayList<>();
        for (String productInfo : productsInfo) {
            String[] info = productInfo.split(",");
            Product product = new Product(info[0], info[1], info[2]);
            productShelf.add(product);
        }
        return productShelf;
    }

    public List<Product> bringShelf() {
        return productShelf;
    }

    public int hasSuchProduct(String wishList) {
        for(Product product: productShelf){
            if(product.askName().equals(wishList)){
                return productShelf.indexOf(product);
            }
        }
        return FALSE;
    }
    public int getPrice(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        return product.askPrice();
    }
    public void decreaseStock(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        product.sellProduct();
    }
}
