package vendingmachine.service;


import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.utils.Message;
import vendingmachine.utils.Validation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineService {

    private final VendingMachineValidation vendingMachineValidation;
    private final VendingMachineRepository vendingMachineRepository;
    private VendingMachine vendingMachine;

    public VendingMachineService() {
        this.vendingMachineValidation = new VendingMachineValidation();
        setVendingMachine();
        this.vendingMachineRepository = new VendingMachineRepository(this.vendingMachine);
    }

    public void setVendingMachine(){
        int amount = vendingMachineValidation.changeValidation();
        int[] coins = makeRandomCoins(amount);
        OutputView.printVendingMachineCoins(coins);

        List<String> products = vendingMachineValidation.productValidation();
        this.vendingMachine = new VendingMachine(amount,coins,products);
    }

    private int[] makeRandomCoins(int amount){
        int nowPrice = amount;
        int[] coinList = new int[4];
        while(nowPrice > 0){
            for(Coin coin : Coin.values()) {
                int quantity = coin.convertPriceToCoins(coin, nowPrice);
                coinList[coin.ordinal()] += quantity;
                nowPrice -= coin.calculateBalance(quantity);
            }
        }
        return coinList;
    }



    public void start(){
        int balance = vendingMachineValidation.inputAmountValidation();
        while(true){
            System.out.println("투입 금액: " + balance + "원");
            try{
                if(!balanceCheck(balance)) {
                    printChange(balance);
                    break;
                }
                System.out.println("구매할 상품명을 입력하세요");
                String order = InputView.input();
                balance = buyProduct(balance, order);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void printChange(int balance){
        int change = vendingMachineRepository.findChange();
        List<Integer> vendingMachineCoins = vendingMachineRepository.findCoins();
        if(balance > change){
            OutputView.printVendingMachineCoins(vendingMachineCoins.stream().mapToInt(i->i).toArray());
            return;
        }

        int[] changeCoinList = new int[4];
        int i = 0;
        for(Coin coin : Coin.values()){
            int coinNum = coin.calculateChange(balance);
            if(coinNum > vendingMachineCoins.get(i)){
                coinNum = vendingMachineCoins.get(i);
            }
            changeCoinList[i] = coinNum;
            balance -= coin.getAmount() * coinNum;
            if(balance == 0){
                break;
            }
        }
        OutputView.printChangeCoins(changeCoinList);
    }

    private boolean balanceCheck(int balance){
        if(balance < vendingMachineRepository.findMinPrice()){
            return false;
        }
        List<Integer> quantities = vendingMachineRepository.findAllQuantity();
        if(quantities.stream().mapToInt(Integer::intValue).sum() == 0){
            return false;
        }
        return true;
    }

    public int buyProduct(int amount, String name){
        Product product = vendingMachineRepository.findByName(name);
        return vendingMachine.buy(amount,product);
    }

}
