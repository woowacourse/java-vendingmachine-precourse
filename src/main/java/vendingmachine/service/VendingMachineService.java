package vendingmachine.service;


import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;
import static vendingmachine.domain.Product.isZeroQuantity;

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
        List<Integer> randomCoinList = new ArrayList<>();
        while (amount > 0) {
            int coin = pickCoin(amount);
            amount -= coin;
            randomCoinList.add(coin);
        }

        int[] countList = countFrequency(randomCoinList);

        return countList;
    }

    public int pickCoin(int amount){
        List<Coin> possibleCoinList = new ArrayList<>();
        for(Coin coin : Coin.values()){
            if(isPossible(amount,coin)){
                possibleCoinList.add(coin);
            }
        }
        int coin = pickNumberInList(convertAmountList(possibleCoinList));
        return coin;
    }

    
    public int[] countFrequency(List<Integer> randomCoinList){
        int[] frequencyList = new int[4];
        int[] coinList = {500,100,50,10};
        for(int i = 0; i < 4; i++){
            frequencyList[i] = Collections.frequency(randomCoinList,coinList[i]);
        }
        return frequencyList;
    }
    
    public void start(){
        int balance = vendingMachineValidation.inputAmountValidation();
        while(true){
            System.out.println("투입 금액: " + balance + "원");
            try{
                if(!availableCheck(balance)) {
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

        int[] changeCoinList = makeChangeCoinList(vendingMachineCoins, balance);

        OutputView.printChangeCoins(changeCoinList);
    }

    private int[] makeChangeCoinList(List<Integer> vendingMachineCoins, int balance){
        int[] changeCoinList = new int[4];
        int i = 0;
        for(Coin coin : Coin.values()){
            int coinNum = coin.calculateChange(balance);
            if(coinNum > vendingMachineCoins.get(i)){
                coinNum = vendingMachineCoins.get(i);
                changeCoinList[i] = coinNum;
                balance -= coin.multiply(coinNum);
                if(balance == 0){
                    break;
                }
                i++;
            }
        }
        return changeCoinList;
    }

    private boolean availableCheck(int balance){
        int minPrice = vendingMachineRepository.findMinPrice();
        if(balance < minPrice){
            return false;
        }

        if(isZeroQuantity(vendingMachineRepository.findByPrice(minPrice))){
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
