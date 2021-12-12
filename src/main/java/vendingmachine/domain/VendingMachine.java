package vendingmachine.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class VendingMachine {

    private final int DEFAULT_AMOUNT = 0;
    protected final int PRODUCT_INFORMATION_SIZE = 3;
    private int amount;
    private int inputMoney;
    private Map<Coin, Integer> coinMap;
    private ProductList productList;

    public VendingMachine(int amount) {
        productList = new ProductList();
        this.amount = amount;
        //TODO: amount validate 검증
        generateNumberOfCoinsRandomly(amount);
    }

    private void generateNumberOfCoinsRandomly(int amount) {
        coinMap = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {
            int randomValue = Randoms.pickNumberInRange(0, amount/coin.getValue());
            amount -= randomValue;
            coinMap.put(coin, randomValue);
        }

        if (amount > DEFAULT_AMOUNT) {
            for (Coin coin : Coin.values()) {
                int quotient = amount/coin.getValue();
                amount -= quotient * coin.getValue();
                coinMap.put(coin, coinMap.get(coin) + quotient);
            }
        }
    }

    private Product transferRawDataToEntity(String productRawData) {

        String[] productInfo = productRawData.split(",");
        // TODO: 예외 처리
        if (productInfo.length != PRODUCT_INFORMATION_SIZE) return null;
        return new Product(productInfo[0], productInfo[1], productInfo[2]);

    }

    public void insertProducts(String products) {
        StringTokenizer stringTokenizer = new StringTokenizer(products, ";");
        // TODO: 예외 처리
        if(!stringTokenizer.hasMoreTokens()) return;

        while(stringTokenizer.hasMoreTokens()) {
            String currentProduct = stringTokenizer.nextToken();
            Product product = transferRawDataToEntity(currentProduct);
            productList.insertProduct(product);
        }
    }

    public void setInputMoney(int money) {
        this.inputMoney = money;
    }
}
