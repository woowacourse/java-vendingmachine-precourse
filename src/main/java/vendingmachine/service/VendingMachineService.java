package vendingmachine.service;


import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
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

    public void setVendingMachine(){
        int amount = vendingMachineValidation.changeValidation();
        int[] coins = coinService.makeRandomCoins(amount);
        OutputView.printVendingMachineCoins(coins);

        List<String> products = vendingMachineValidation.productValidation();
        this.vendingMachine = new VendingMachine(amount,coins,products);
    }

    
    public void start(){
        int balance = vendingMachineValidation.inputAmountValidation();
        while(true){
            System.out.printf(Message.BALANCE, balance);
            try{
                if(!vendingMachine.availableCheck(balance)) {
                    printChange(balance);
                    break;
                }
                System.out.println(Message.PRODUCT_NAME_INPUT);
                String order = InputView.input();
                balance = buyProduct(balance, order);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int buyProduct(int amount, String name){
        return vendingMachine.buy(amount, name);
    }

    private int[] makeChangeCoinList(int[] vendingMachineCoins, int balance){
        int[] changeCoinList = new int[4];
        int i = 0;
        for(Coin coin : Coin.values()){
            int needCoin = coin.calculateChange(balance);
            int haveCoin = vendingMachineCoins[i];
            if(balance == 0){
                break;
            }
            changeCoinList[i] = compareCoin(needCoin,haveCoin);
            balance -= coin.multiply(changeCoinList[i]);
            i++;
        }
        return changeCoinList;
    }

    private int compareCoin(int needCoin, int haveCoin){
        if(needCoin > haveCoin){
            return haveCoin;
        }
        return needCoin;
    }



    private void printChange(int balance){

        int[] vendingMachineCoins = vendingMachine.coinsToArray();

        if(vendingMachine.isBalanceBigger(balance)){
            OutputView.printVendingMachineCoins(vendingMachineCoins);
            return;
        }

        int[] changeCoinList = makeChangeCoinList(vendingMachineCoins, balance);

        OutputView.printChangeCoins(changeCoinList);
    }


}
