package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.utils.Coin;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.Symbol;

public class VendingMachine {

    public static final int PRODUCT_INFORMATION_NAME_INDEX = 0;
    public static final int PRODUCT_INFORMATION_PRICE_INDEX = 1;
    public static final int PRODUCT_INFORMATION_COUNT_INDEX = 2;

    private final int machineMoney;
    private List<Product> products;

    public VendingMachine(final int machineMoney) {
        validateMachineMoney(machineMoney);
        this.machineMoney = machineMoney;
    }

    public List<Product> fillProducts(List<String> inputProductInformation) {
        final List<Product> productList = new ArrayList<>();

        for (String inputProduct : inputProductInformation) {
            String [] splitInputProduct = inputProduct.split(Symbol.COMMA.getSymbol());
            final List<String> productInformation = Arrays.asList(splitInputProduct);
            Product product = createProduct(productInformation);

            productList.add(product);
        }

        return productList;
    }

    protected Product createProduct(final List<String> productInformation) {
        String name = productInformation.get(PRODUCT_INFORMATION_NAME_INDEX);
        int price = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_PRICE_INDEX));
        int count = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_COUNT_INDEX));

        return new Product(name, price, count);
    }

    protected void validateMachineMoney(final int inputMachineMoney) {
        if (!isMultiplyTen(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_UNIT.getErrorMessage());
        }
    }

    protected boolean isMultiplyTen(final int inputMachineMoney) {
        return (inputMachineMoney % 10) == 0;
    }

    public List<Integer> calculateCoins(final int machineMoney, final List<Integer> coins) {
        List<Integer> machineCoins = new ArrayList<>();
        int machineMoneyToCountCoin = machineMoney;

        while (machineMoneyToCountCoin != 0) {
            machineCoins = new ArrayList<>();
            machineMoneyToCountCoin = machineMoney;

            machineMoneyToCountCoin = inputCoinRandomly(machineCoins, coins, machineMoneyToCountCoin);
        }

        return machineCoins;
    }


    protected int inputCoinRandomly(final List<Integer> machineCoins, final List<Integer> coins, int machineMoneyToCountCoin) {
        for (int coinUnit : coins) {
            int share = machineMoneyToCountCoin / coinUnit;

            final List<Integer> inputRandomCoinRange = createCoinRangeList(share);
            int coinCount = Coin.COIN_500.inputCoinCountRandomly(inputRandomCoinRange);

            machineMoneyToCountCoin = machineMoney - (coinCount * coinUnit);
            machineCoins.add(coinCount);
        }

        return machineMoneyToCountCoin;
    }


    protected List<Integer> createCoinRangeList(final int share) {
        final List<Integer> inputRandomCoinRange = new ArrayList<>();

        for (int j = 0; j <= share; j++) {
            inputRandomCoinRange.add(j);
        }

        return inputRandomCoinRange;
    }

    public List<Integer> createCoinUnitList() {
        final List<Integer> coinUnitList = new ArrayList<>();
        Coin[] coin = Coin.values();

        for (int i = 0; i < Coin.values().length; i++) {
            coinUnitList.add(coin[i].getAmount());
        }

        return coinUnitList;
    }

}
