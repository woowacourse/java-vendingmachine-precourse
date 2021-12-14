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

    public Map<Integer, Integer> returnChange(final Map<Integer, Integer> machineCoins, final int purchasingCost) {
        return calculateReturnChangeCoin(machineCoins, purchasingCost);
    }

    public boolean isContinuePurchasing(final List<Product> products, final int cheapestProductPrice, final int purchasingCost) {
        boolean isContinueDeal = isCostBiggerCheapestProductPrice(cheapestProductPrice, purchasingCost);

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
        final List<Integer> inputRandomCoinRange = createCoinRangeList();

        return inputCoinRandomly(inputRandomCoinRange, machineMoney);
    }

    protected Map<Integer, Integer> inputCoinRandomly(final List<Integer> inputRandomCoinRange, int machineMoneyToCountCoin) {
        Map<Integer, Integer> machineCoins = createMachineCoins();
        machineCoins = changeMachineMoneyToCoin(inputRandomCoinRange, machineMoneyToCountCoin, machineCoins, machineMoneyToCountCoin);

        return machineCoins;
    }

    protected Map<Integer, Integer> changeMachineMoneyToCoin(final List<Integer> inputRandomCoinRange, final int machineMoneyToCountCoin, Map<Integer, Integer> machineCoins, int machineMoney) {
        while (machineMoney != 0) {
            int coinUnit = Coin.COIN_500.inputCoinCountRandomly(inputRandomCoinRange);
            int coinCount = (machineMoneyToCountCoin / coinUnit);

            machineMoney = addCoin(machineCoins, machineMoney, coinUnit, coinCount);

            if (machineMoney < 0) {
                machineCoins = createMachineCoins();
                machineMoney = machineMoneyToCountCoin;
            }
        }

        return machineCoins;
    }

    protected int addCoin(final Map<Integer, Integer> machineCoins, int machineMoney, final int coinUnit, final int coinCount) {
        if (coinCount > 0) {
            machineCoins.put(coinUnit, machineCoins.get(coinUnit) + 1);
            machineMoney = machineMoney - coinUnit;
        }

        return machineMoney;
    }

    protected List<Integer> createCoinRangeList() {
        List<Integer> coinRange = new ArrayList<>();
        Coin[] coinUnits = Coin.values();

        for (final Coin coinUnit : coinUnits) {
            coinRange.add(coinUnit.getAmount());
        }

        return coinRange;
    }

    protected Map<Integer, Integer> createMachineCoins() {
        final Map<Integer, Integer> machineCoins = new LinkedHashMap<>();
        Coin[] coins = Coin.values();

        for (final Coin coin : coins) {
            machineCoins.put(coin.getAmount(), 0);
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

    public void validateShortMoney(final List<Product> products, final String purchasingProductName, final int purchasingCost) {
        boolean checkShortMoney = false;

        for (Product product : products) {
            if (product.getName().compareProductName(purchasingProductName)) {
                checkShortMoney = product.getPrice().isShortMoney(purchasingCost);
            }
        }

        if (!checkShortMoney) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_SHORT_MONEY.getErrorMessage());
        }
    }

}
