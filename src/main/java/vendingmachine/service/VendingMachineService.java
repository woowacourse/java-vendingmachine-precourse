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

    private void setVendingMachine(){
        int change = vendingMachineValidation.changeValidation();
        int[] coins = coinService.makeRandomCoins(change);
        OutputView.printVendingMachineCoins(coins);

        List<String> products = vendingMachineValidation.productValidation();
        this.vendingMachine = new VendingMachine(change,coins,products);
    }


    public void start(){
        int balance = vendingMachineValidation.balanceValidation();
        while(true){
            System.out.printf(Message.BALANCE, balance);
            try{
                if(!vendingMachine.availableCheck(balance)) {
                    printChange(balance);
                    break;
                }
                balance = vendingMachineRunning(balance);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int vendingMachineRunning(int balance){
        String order = vendingMachineValidation.orderValidation();
        balance = buyProduct(balance, order);
        return balance;
    }

    private int buyProduct(int amount, String name){
        return vendingMachine.buy(amount, name);
    }

    private int[] makeChangeCoinList(int[] vendingMachineCoins, int balance){
        int[] changeCoinList = new int[4];
        int i = 0;
        for(Coin coin : Coin.values()){
            if(balance == 0){
                break;
            }
            int needCoinNum = coin.calculateNeedCoin(balance);
            int haveCoinNum = vendingMachineCoins[i];
            changeCoinList[i] = coinService.compareCoinNum(needCoinNum,haveCoinNum);
            balance -= coin.calcalateCovertedAmount(changeCoinList[i]);
            i++;
        }
        return changeCoinList;
    }


    private void printChange(int balance){
        int[] vendingMachineCoinList = vendingMachine.coinsToArray();

        if(vendingMachine.isBalanceBigger(balance)){
            OutputView.printVendingMachineCoins(vendingMachineCoinList);
            return;
        }

        int[] changeCoinList = makeChangeCoinList(vendingMachineCoinList, balance);

        OutputView.printChangeCoins(changeCoinList);
    }

}
