package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.utils.ExceptionMessages;

public class VendingMachine {

    private final int machineMoney;

    public VendingMachine(final int machineMoney) {
        validateMachineMoney(machineMoney);
        this.machineMoney = machineMoney;
    }

    public boolean isContinueDeal(final List<Product> products, final int cheapestProductPrice, final int purchasingCost) {
        boolean isContinueDeal = purchasingCost >= cheapestProductPrice;

        System.out.println("구매비용: "+purchasingCost);
        System.out.println("가장 싼 제품: "+cheapestProductPrice);

        for (Product product : products) {
            if (product.getCount().isCountValidation()) {
                isContinueDeal = false;
            }
        }

        return isContinueDeal;
    }


    protected void validateMachineMoney(final int inputMachineMoney) {
        if (!isMultiplyTen(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MACHINE_MONEY_CONDITION.getErrorMessage());
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

    public void validatePurchasingProductName(final List<Product> products, final String purchasingProductName) {
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

    public int calculateRemainingPurchasingCost(final List<Product> products, final String choosePurchasingProductName, int purchasingCost) {
        for (Product product : products) {
            if (product.getName().compareProductName(choosePurchasingProductName)) {
                purchasingCost = product.getPrice().subtractPrice(purchasingCost);
            }
        }

        return purchasingCost;
    }
}
