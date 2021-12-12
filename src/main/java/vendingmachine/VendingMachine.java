package vendingmachine;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.glass.ui.Clipboard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VendingMachine {

    Map<Coin, Integer> coinBox;
    List<Product> products;

    public VendingMachine() {
        this.coinBox = new LinkedHashMap<>();
        List<Coin> sortedCoins = Arrays.stream(Coin.values()).sorted().collect(Collectors.toList());
        for (Coin coin : sortedCoins) {
            coinBox.put(coin, 0);
        }
    }

    public void setBaseAsset() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int asset = Integer.parseInt(Console.readLine());
        generateRandomCoinBasedOnAsset(asset);
        announceCoinStock();
    }

    public void setProducts() {
        products = new ArrayList<>();
        System.out.println("상품명과 가격, 수량을 입력해 주세요. [상품명,가격,수량];[,,] 형태");
        List<String> rawProducts = asList(Console.readLine().split(";"));
        collectProducts(rawProducts);
    }

    private void generateRandomCoinBasedOnAsset(int asset) {
        Set<Coin> coins = coinBox.keySet();
        while (asset > 0) {
            for (Coin coin : coins) {
                int amount = coin.getCoinValue();
                int maxCoinCount = asset / amount;
                List<Integer> availableNumbers = makeAvailableNumbers(maxCoinCount);
                int randomCoinCount = Randoms.pickNumberInList(availableNumbers);
                asset -= amount * randomCoinCount;
                coinBox.put(coin, randomCoinCount + coinBox.get(coin));
            }
        }
    }

    private List<Integer> makeAvailableNumbers(int maxCoinCount) {
        List<Integer> tempNumbers = new ArrayList<>();
        for (int i = 0; i <= maxCoinCount; i++) {
            tempNumbers.add(i);
        }
        return tempNumbers;
    }

    private void announceCoinStock() {
        System.out.println("\n자판기가 보유한 동전");
        Set<Coin> coins = coinBox.keySet();
        for (Coin coin : coins) {
            System.out.println(coin.getCoinValue() + "원" + " - " + coinBox.get(coin) + "개");
        }
    }

    private String removeSquareBrackets(String rawProduct) {
        return rawProduct.substring(1, rawProduct.length() - 1);
    }

    private void collectProducts(List<String> rawProducts) {
        for (int i = 0; i < rawProducts.size(); i++) {
            String rawProduct = removeSquareBrackets(rawProducts.get(i));
            String[] sliceProductInformation = rawProduct.split(",");
            try {
                String productName = sliceProductInformation[0];
                Integer productPrice = Integer.parseInt(sliceProductInformation[1]);
                Integer productQuantity = Integer.parseInt(sliceProductInformation[2]);
                validatePrice(productPrice);
                products.add(new Product(productName, productPrice, productQuantity));
            } catch (IllegalArgumentException e) {
                setProducts();
            }
        }
    }

    private void validatePrice(Integer productPrice) {
        if (productPrice < 100) {
            System.out.println("[ERROR] 상품 가격은 100원 이상이어야 합니다.");
            throw new IllegalArgumentException();
        }
        if ((productPrice % 10) != 0) {
            System.out.println("[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
