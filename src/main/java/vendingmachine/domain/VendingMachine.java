package vendingmachine.domain;

import static vendingmachine.ErrorMessage.ERROR_CUSTOMER_MONEY_INPUT;
import static vendingmachine.ErrorMessage.ERROR_NOT_ENOUGH_CUSTOMER_MONEY;
import static vendingmachine.ErrorMessage.ERROR_VENDING_MACHINE_INPUT_MONEY;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

public class VendingMachine {
    private static final String machineMoneyRegex = "\\b(?:[0-9]*0)\\b";
    private static final String customerMoneyRegex = "^\\d+$";
    private static final Pattern machineMoneyPattern = Pattern.compile(machineMoneyRegex);
    private static final Pattern customerMoneyPattern = Pattern.compile(customerMoneyRegex);
    private final LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();
    private final int machineMoney;
    private int customerMoney;

    public VendingMachine(String moneyInput) {
        this.machineMoney = validateMachineMoney(moneyInput);
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
        generateCoins();
    }

    public void changeCustomerMoney(String customerMoneyInput) {
        customerMoney = validateCustomerMoney(customerMoneyInput);
    }

    public void buyGoods(int goodsPrice) {
        if (customerMoney < goodsPrice) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_CUSTOMER_MONEY.getMessage());
        }
        customerMoney -= goodsPrice;
    }

    public LinkedHashMap<Coin, Integer> calculateChanges() {
        LinkedHashMap<Coin, Integer> changes = new LinkedHashMap<>();
        changes.put(Coin.COIN_500, 0);
        changes.put(Coin.COIN_100, 0);
        changes.put(Coin.COIN_50, 0);
        changes.put(Coin.COIN_10, 0);
        for (Coin coinValue : coins.keySet()) {
            while (customerMoney >= coinValue.getAmount() && coins.get(coinValue) >= 1) {
                changes.put(coinValue, changes.get(coinValue) + 1);
                customerMoney -= coinValue.getAmount();
                coins.put(coinValue, coins.get(coinValue) - 1);
            }
        }
        return changes;
    }

    public VendingMachineDto toDto() {
        return new VendingMachineDto(coins.get(Coin.COIN_500), coins.get(Coin.COIN_100),
                coins.get(Coin.COIN_50), coins.get(Coin.COIN_10), customerMoney);
    }

    private int validateMachineMoney(String machineMoneyInput) {
        if (machineMoneyPattern.matcher(machineMoneyInput).matches()) {
            return Integer.parseInt(machineMoneyInput);
        }
        throw new IllegalArgumentException(ERROR_VENDING_MACHINE_INPUT_MONEY.getMessage());
    }

    private int validateCustomerMoney(String customerMoneyInput) {
        if (customerMoneyPattern.matcher(customerMoneyInput).matches()) {
            return Integer.parseInt(customerMoneyInput);
        }
        throw new IllegalArgumentException(ERROR_CUSTOMER_MONEY_INPUT.getMessage());
    }

    private void generateCoins() {
        int localMoney = machineMoney;
        List<Integer> random = List.of(500, 100, 50, 10);
        while (localMoney != 0) {
            int randomNumber = Randoms.pickNumberInList(random);

            if (randomNumber == 500 && localMoney >= 500) {
                coins.put(Coin.COIN_500, coins.get(Coin.COIN_500) + 1);
                localMoney -= 500;
            }
            if (randomNumber == 100 && localMoney >= 100) {
                coins.put(Coin.COIN_100, coins.get(Coin.COIN_100) + 1);
                localMoney -= 100;
            }

            if (randomNumber == 50 && localMoney >= 50) {
                coins.put(Coin.COIN_50, coins.get(Coin.COIN_50) + 1);
                localMoney -= 50;
            }

            if (randomNumber == 10) {
                coins.put(Coin.COIN_10, coins.get(Coin.COIN_10) + 1);
                localMoney -= 10;
            }
        }
    }

}
