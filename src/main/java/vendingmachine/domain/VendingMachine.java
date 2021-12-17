package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessage;
import vendingmachine.utils.Validator;
import vendingmachine.view.VendingMachineOutput;
import vendingmachine.utils.CommonConstant;

import java.util.*;

public class VendingMachine {

    private int inputMoney;
    private CoinMap coinMap;
    private ProductList productList;

    public VendingMachine(int amount) {
        generateRandomNumber(amount);
    }

    private void generateRandomNumber(int amount) {
        coinMap = new CoinMap();
        coinMap.generateNumberOfCoinsRandomly(amount);
    }

    private Product transferRawDataToEntity(String productRawData) {
        String[] productInfo = productRawData.split(",");
        Validator.validateProductInformationSize(productInfo.length);

        return new Product(productInfo[0], productInfo[1], productInfo[2]);

    }

    public void insertProducts(String products) {
        productList = new ProductList();
        StringTokenizer stringTokenizer = new StringTokenizer(products, "[];");
        Validator.validateProductInformationIsNull(stringTokenizer);

        while(stringTokenizer.hasMoreTokens()) {
            String currentProduct = stringTokenizer.nextToken();
            Product product = transferRawDataToEntity(currentProduct);
            productList.insertProduct(product);
        }
    }

    public void setInputMoney(int money) {
        this.inputMoney = money;
    }

    public boolean checkPurchasePossible() {
        return productList.checkPurchasePossible(inputMoney) && productList.checkAllProductsSoldOut();
    }

    private void reduceInputMoney(int money) {
        this.inputMoney -= money;
    }

    public void reduceInputMoneyAndProductQuantityByName(String name) {
        Product[] products = productList.returnProductUsingName(name);
        if(products.length <= CommonConstant.DEFAULT_AMOUNT) {
            System.out.println(ExceptionMessage.NOT_AVAILABLE);
            return;
        }

        for(Product product : products) {
            if(!product.checkQuantityEnough()) {
                System.out.println(ExceptionMessage.OUT_OF_STOCK);
                return;
            }
            if(!product.checkPurchasePossible(inputMoney)) {
                System.out.println(ExceptionMessage.BALANCE_IS_INSUFFICIENT);
                return;
            }
            reduceInputMoney(product.price);
            product.reduceQuantity();
        }

    }
    // 잔돈 생성
    private int calculateCoinUsingAmount(Coin coin) {
        int quotient = inputMoney / coin.getValue();
        return coinMap.calculateValueUsingQuotient(coin, quotient);
    }

    private Map<Coin, Integer> generateChanges() {
        Map<Coin, Integer> changes = new LinkedHashMap<>();
        for(Coin coin : Coin.values()) {
            int usingAmount = calculateCoinUsingAmount(coin);
            if (usingAmount == CommonConstant.DEFAULT_AMOUNT) continue;
            reduceInputMoney(usingAmount * coin.getValue());
            changes.put(coin, usingAmount);
        }
        return changes;
    }

    public void printChanges() {
        Map<Coin, Integer> changes = generateChanges();
        VendingMachineOutput.printChange(changes);
    }

    public void printCoins() {
        VendingMachineOutput.printCoinsVendingMachineHas(coinMap);
    }

    public void printRestMoney() {
        VendingMachineOutput.printRestMoney(inputMoney);
    }
}
