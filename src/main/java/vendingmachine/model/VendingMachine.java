package vendingmachine.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.utils.ExceptionMessages;

public class VendingMachine {

    private final Map<Integer, Integer> machineCoins;

    public VendingMachine(final int machineMoney) {
        validateMachineMoney(machineMoney);
        this.machineCoins = calculateCoins(machineMoney);
    }


    public Map<Integer, Integer> getMachineCoins() {
        return machineCoins;
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

    protected Map<Integer, Integer> calculateCoins(final int machineMoney) {
        Map<Integer, Integer> machineCoins = createCoinUnitList();
        int machineMoneyToCountCoin = machineMoney;

        while (machineMoneyToCountCoin != 0) {
            machineMoneyToCountCoin = machineMoney;

            machineMoneyToCountCoin = inputCoinRandomly(machineCoins, machineMoneyToCountCoin);
        }

        return machineCoins;
    }


    protected int inputCoinRandomly(final Map<Integer, Integer> machineCoins, int machineMoneyToCountCoin) {
        for (int machineCoin : machineCoins.keySet()) {
            int share = (machineMoneyToCountCoin / machineCoin);

            final List<Integer> inputRandomCoinRange = createCoinRangeList(share);
            int coinCount = Coin.COIN_500.inputCoinCountRandomly(inputRandomCoinRange);

            machineMoneyToCountCoin = machineMoneyToCountCoin - (coinCount * machineCoin);
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

    public Map<Integer, Integer> createCoinUnitList() {
        final Map<Integer, Integer> machineCoins = new LinkedHashMap<>();
        Coin[] coin = Coin.values();

        for (int i = 0; i < Coin.values().length; i++) {
            machineCoins.put(coin[i].getAmount(), 0);
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

    public Map<Integer, Integer> calculateReturnChangeCoin(final Map<Integer, Integer> machineCoins, int purchasingCost) {
        final Map<Integer, Integer> returnChange = new LinkedHashMap<>();

        for (int machineCoin : machineCoins.keySet()) {
            int machineCoinCount = machineCoins.get(machineCoin);

            if (machineCoinCount != 0) {
                int coinCount = calculateMaximumCoinCount(machineCoinCount, purchasingCost, machineCoin);
                purchasingCost = purchasingCost - (coinCount * machineCoin);
                returnChange.put(machineCoin, coinCount);
            }
        }

        return returnChange;
    }

    private int calculateMaximumCoinCount(final int machineCoinCount, final int purchasingCost, final int coinUnit) {
        int coinCount = purchasingCost / coinUnit;

        if (coinCount > machineCoinCount) {
            coinCount = machineCoinCount;
        }

        return coinCount;
    }

}
