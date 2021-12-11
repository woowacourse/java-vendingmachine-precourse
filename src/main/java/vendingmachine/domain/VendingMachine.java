package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.utils.Coin;

public class VendingMachine {

    private final int machineMoney;

    public VendingMachine(final String fillMachineMoney) {
        this.machineMoney = Integer.parseInt(fillMachineMoney);
    }

    public List<Integer> calculateCoins(final String inputMachineMoney, final List<Integer> coins) {
        List<Integer> machineCoins = new ArrayList<>();
        int machineMoney = Integer.parseInt(inputMachineMoney);

        while (machineMoney != 0) {
            machineCoins = new ArrayList<>();
            machineMoney = Integer.parseInt(inputMachineMoney);

            machineMoney = inputCoinRandomly(machineCoins, coins, machineMoney);
        }

        return machineCoins;
    }


    protected int inputCoinRandomly(final List<Integer> machineCoins, final List<Integer> coins, int machineMoney) {
        for (int coinUnit : coins) {
            int share = machineMoney / coinUnit;

            final List<Integer> inputRandomCoinRange = createCoinRangeList(share);
            int coinCount = Coin.COIN_500.inputCoinCountRandomly(inputRandomCoinRange);

            machineMoney = machineMoney - (coinCount * coinUnit);
            machineCoins.add(coinCount);
        }

        return machineMoney;
    }


    protected List<Integer> createCoinRangeList(final int share) {
        final List<Integer> inputRandomCoinRange = new ArrayList<>();

        for (int j = 0; j <= share; j++) {
            inputRandomCoinRange.add(j);
        }

        return inputRandomCoinRange;
    }

    public List<Integer> createCoinList() {
        final List<Integer> coins = new ArrayList<>();
        Coin[] coin = Coin.values();

        for (int i = 0; i < Coin.values().length; i++) {
            coins.add(coin[i].getAmount());
        }

        return coins;
    }

}
