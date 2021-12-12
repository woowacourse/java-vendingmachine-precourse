package vendingmachine.service;


import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Message;
import vendingmachine.utils.VendingMachineValidation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.*;

public class VendingMachineService {

    private final VendingMachineValidation vendingMachineValidation;
    private final CoinService coinService;
    private VendingMachine vendingMachine;

    public VendingMachineService() {
        this.coinService = new CoinService();
        this.vendingMachineValidation = new VendingMachineValidation();
        setVendingMachine();
    }

    private void setVendingMachine() {
        int change = vendingMachineValidation.changeValidation();
        int[] coins = coinService.makeRandomCoins(change);
        OutputView.printVendingMachineCoins(coins);

        List<String> products = vendingMachineValidation.productValidation();
        this.vendingMachine = new VendingMachine(change, coins, products);
    }


    public void start() {
        int balance = vendingMachineValidation.balanceValidation();
        while (true) {
            System.out.printf(Message.BALANCE, balance);
            //TODO: vendingMachineRunning으로 분리
            try {
                if (!vendingMachine.availableCheck(balance)) {
                    printChange(balance);
                    break;
                }
                System.out.println(Message.PRODUCT_NAME_INPUT);
                String order = InputView.input();
                balance = buyProduct(balance, order);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int buyProduct(int amount, String name) {
        return vendingMachine.buy(amount, name);
    }

    private int[] makeChangeCoinList(int[] vendingMachineCoins, int balance) {
        int[] changeCoinList = new int[4];
        int i = 0;
        for (Coin coin : Coin.values()) {
            if (balance == 0) {
                break;
            }
            int needCoin = coin.calculateNeedCoin(balance);
            int haveCoin = vendingMachineCoins[i];
            changeCoinList[i] = coinService.compareCoin(needCoin, haveCoin);
            balance -= coin.multiply(changeCoinList[i]);
            i++;
        }
        return changeCoinList;
    }


    private void printChange(int balance) {
        int[] vendingMachineCoinList = vendingMachine.coinsToArray();

        if (vendingMachine.isBalanceBigger(balance)) {
            OutputView.printVendingMachineCoins(vendingMachineCoinList);
            return;
        }

        int[] changeCoinList = makeChangeCoinList(vendingMachineCoinList, balance);

        OutputView.printChangeCoins(changeCoinList);
    }

}
