package vendingmachine.controller;

import static vendingmachine.Coin.initVendingMachineCoins;
import static vendingmachine.Messages.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.Coin;
import vendingmachine.Product;
import vendingmachine.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Products products = new Products();

    private Map<Integer, Integer> vendingMachineCoins = new TreeMap<>(Collections.reverseOrder());
    private int vendingMachineCoin;
    private String productName;

    public void run() {
        initVendingMachine();
        outputView.printVendingMachineCoin();
        outputView.printCoins(vendingMachineCoins);
        List<Product> productList = inputProductsProcess();
        int money = inputView.inputMoney();
        do {
            money = purchasingProcess(productList, money);
        } while (isContinue(productList, money));
        outputView.printRemainingCoins(getRemainingCoins(money), money);
    }

    //자판기 초기화
    private void initVendingMachine() {
         inputVendingMachineCoinProcess();
        try {
            validateCoin(vendingMachineCoin);
            vendingMachineCoins = initVendingMachineCoins(vendingMachineCoin);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            initVendingMachine();
        }
    }

    //자판기 입력 과정
    public void inputVendingMachineCoinProcess() {
        try {
            vendingMachineCoin = inputView.inputVendingMachineCoin();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputVendingMachineCoinProcess();
        }
    }

    //10원 단위 예외 처리
    private void validateCoin(int vendingMachineCoin) {
        if (vendingMachineCoin % 10 != 0) {
            throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_UNIT);
        }
    }

    //상품 목록 입력 과정
    public List<Product> inputProductsProcess() {
        String inputProducts = inputView.inputProducts();
        List<Product> productList = products.getProducts(inputProducts);
        try {
            products.validateProductsPrice(productList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputProductsProcess();
        }
        return productList;
    }

    //상품 구매 과정
    public int purchasingProcess(List<Product> productList, int money) {
        outputView.printUserMoney(money);
        productName = inputView.inputProductName();
        try {
            products.validateProductName(productName, productList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            purchasingProcess(productList, money);
        }
        return products.calculate(productList, money, productName);
    }

    //종료 조건 확인
    public boolean isContinue(List<Product> productList, int money) {
        return money > products.getMinimumPrice(productList)
                && products.hasCount(productList, productName);
    }

    //잔돈 반환
    public Map<Integer, Integer> getRemainingCoins(int money) {
        Map<Integer, Integer> remainingCoins = new TreeMap<>(Collections.reverseOrder());
        for (Integer coin : vendingMachineCoins.keySet()) {
            remainingCoins = calculateRemainingCoins(money, coin);
        }
        return remainingCoins;
    }

    //잔돈 계산
    public Map<Integer, Integer> calculateRemainingCoins(int money, int coin) {
        Map<Integer, Integer> remainingCoins = new TreeMap<>(Collections.reverseOrder());
        while (money / coin != 0 && vendingMachineCoins.get(coin) != 0) {
            vendingMachineCoins.put(coin, vendingMachineCoins.get(coin) - 1);
            remainingCoins.put(coin, remainingCoins.getOrDefault(coin, 0) + 1);
            money = Coin.calculateMoney(money, coin);
        }
        return remainingCoins;
    }
}