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
                nowPrice -= coin.calculate(quantity);
            }
        }
        return coinList;
    }



    public void start(){
        int amount = vendingMachineValidation.inputAmountValidation();
        while(amount > 0){
            try{
                System.out.println("투입금액 : " + amount);
                System.out.println("구매할 상품명을 입력하세요");
                String order = InputView.input();
                amount = buyProduct(amount, order);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int buyProduct(int amount, String name){
        Product product = vendingMachineRepository.findByName(name);
        return vendingMachine.buy(amount,product);
    }

}
