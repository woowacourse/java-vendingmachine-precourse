package vendingmachine.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.utils.ExceptionMessages;

public class VendingMachine {

    private final Map<Coin, Integer> machineCoins;

    public VendingMachine(final int machineMoney) {
        validateMachineMoney(machineMoney);
        this.machineCoins = changeMachineMoneyIntoCoins(machineMoney);
    }

    public boolean isContinuePurchasing(final List<Product> products, final int cheapestProductPrice, final int purchasingCost) {
        boolean isContinueDeal = true;

        if (!isCostBiggerCheapestProductPrice(cheapestProductPrice, purchasingCost)) {
            isContinueDeal = false;
        }

        if (!isSoldOutAllProduct(products)) {
            isContinueDeal = false;
        }

        return isContinueDeal;
    }

    protected boolean isSoldOutAllProduct(final List<Product> products) {
        boolean isContinueDeal = false;

        for (Product product : products) {
            if (!(product.getProductCount() == 0)) {
                isContinueDeal = true;
            }
        }

        return isContinueDeal;
    }

    protected boolean isCostBiggerCheapestProductPrice(final int cheapestProductPrice, final int purchasingCost) {
        return purchasingCost >= cheapestProductPrice;
    }


    protected void validateMachineMoney(final int inputMachineMoney) {
        if (!isMultiplyTen(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MACHINE_MONEY_CONDITION.getErrorMessage());
        }
    }

    protected boolean isMultiplyTen(final int inputMachineMoney) {
        return (inputMachineMoney % 10) == 0;
    }

    public Map<Coin, Integer> changeMachineMoneyIntoCoins(final int machineMoney) {
        return calculateCoins(machineMoney);
    }

    public Map<Coin, Integer> calculateCoins(final int machineMoney) {
        Map<Coin, Integer> machineCoins = createCoinUnitList();
        int machineMoneyToCountCoin = machineMoney;

        while (machineMoneyToCountCoin != 0) {
            machineCoins = new LinkedHashMap<>();
            machineMoneyToCountCoin = machineMoney;

            machineMoneyToCountCoin = inputCoinRandomly(machineCoins, machineMoneyToCountCoin);
        }

        return machineCoins;
    }


    protected int inputCoinRandomly(final Map<Coin, Integer> machineCoins, int machineMoneyToCountCoin) {
        for (Coin machineCoin : machineCoins.keySet()) {
            int coinUnit = machineCoin.getAmount();
            int share = (machineMoneyToCountCoin / coinUnit);

            final List<Integer> inputRandomCoinRange = createCoinRangeList(share);
            int coinCount = Coin.COIN_500.inputCoinCountRandomly(inputRandomCoinRange);

            machineMoneyToCountCoin = machineMoneyToCountCoin - (coinCount * coinUnit);
            machineCoins.put(machineCoin, coinCount);
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

    public Map<Coin, Integer> createCoinUnitList() {
        final Map<Coin, Integer> machineCoins = new LinkedHashMap<>();
        Coin[] coin = Coin.values();

        for (int i = 0; i < Coin.values().length; i++) {
            machineCoins.put(coin[i], 0);
        }

        return machineCoins;
    }

    public void validatePurchasingProductNameOnMachine(final List<Product> products, final String purchasingProductName) {
        boolean checkPurchasingProductOnProductList = false;

        for (Product product : products) {
            if (product.getName().compareProductName(purchasingProductName)) {
                checkPurchasingProductOnProductList = true;
            }
        }

        if (!checkPurchasingProductOnProductList) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PURCHASING_PRODUCT_NAME_CONDITION.getErrorMessage());
        }
    }

    public int sellProduct(final List<Product> products, final String choosePurchasingProductName, int purchasingCost) {
        for (Product product : products) {
            if (product.getName().compareProductName(choosePurchasingProductName)) {
                purchasingCost = product.getPrice().subtractPrice(purchasingCost);
                product.getCount().minusCount();
            }
        }

        return purchasingCost;
    }

    public void validatePurchasingProductSoldOut(final List<Product> products, final String purchasingProductName) {
        boolean checkPurchasingProductSoldOut = false;

        for (Product product : products) {
            if (product.getName().compareProductName(purchasingProductName)) {
                checkPurchasingProductSoldOut = product.getCount().isCountValidation();
            }
        }

        if (!checkPurchasingProductSoldOut) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PURCHASING_PRODUCT_SOLD_OUT.getErrorMessage());
        }
    }

    public List<Integer> calculateReturnChangeCoin(final int purchasingCost) {

        return null;
    }

    public Map<Coin, Integer> getMachineCoins() {
        return machineCoins;
    }

}
