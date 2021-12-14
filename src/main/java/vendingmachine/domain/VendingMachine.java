package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NOT_EXIST_PRODUCT = "구매할 수 있는 상품이 존재하지 않습니다. 자판기에서 구매할 수 있고 존재하는 상품을 입력해주세요. ";

    private final CoinCountMap vendingMachineChange;
    private final List<Product> products;
    private int inputMoney;

    public VendingMachine(CoinCountMap vendingMachineChange, List<Product> products, int inputMoney) {
        this.vendingMachineChange = vendingMachineChange;
        this.products = products;
        this.inputMoney = inputMoney;
    }

    public void buyProduct(String inputProductName) {
        Product product = findProudctInVendingMachine(inputProductName);
        inputMoney -= product.getPrice();
        product.buyOneProduct();
    }

    public CoinCountMap getLeftoverCash() {
        if (inputMoney >= vendingMachineChange.getCoinSum()) {
            return vendingMachineChange;
        }
        return calculateLeftoverCash(inputMoney);
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public int getProductsCount() {
        int counts = 0;
        for (Product product : products) {
            counts += product.getCount();
        }
        return counts;
    }

    public int getMinPriceOfProducts() {
        int minValue = Integer.MAX_VALUE;
        for (Product product : products) {
            if (product.getPrice() < minValue && product.getCount() > 0) {
                minValue = product.getPrice();
            }
        }
        return minValue;
    }

    private Product findProudctInVendingMachine(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName) && inputMoney >= product.getPrice() && product.getCount() > 0) {
                return product;
            }
        }
        throw new IllegalArgumentException(ERROR_HEADER + NOT_EXIST_PRODUCT);
    }

    private CoinCountMap calculateLeftoverCash(int toReturnCash) {
        int minCoinCount;
        CoinCountMap leftoverCoinCountMap = new CoinCountMap();
        for (Coin coin : Coin.values()) {
            if (!checkValidMoney(toReturnCash)) {
                return leftoverCoinCountMap;
            }
            minCoinCount = findMinCoinCount(coin, toReturnCash);
            toReturnCash -= minCoinCount * coin.getAmount();
            leftoverCoinCountMap.getCoinCount().replace(coin, leftoverCoinCountMap.getCoinCount().get(coin) + minCoinCount);
            this.vendingMachineChange.getCoinCount().replace(coin, this.vendingMachineChange.getCoinCount().get(coin) - minCoinCount);
        }
        return leftoverCoinCountMap;
    }

    private boolean checkValidMoney(int toReturnCash) {
        if (toReturnCash != 0) {
            return true;
        }
        return false;
    }

    private int findMinCoinCount(Coin coin, int toReturnCash) {
        int coinValue = coin.getAmount();
        return Math.min(toReturnCash / coinValue, this.vendingMachineChange.getCoinCount().get(coin));
    }
}
