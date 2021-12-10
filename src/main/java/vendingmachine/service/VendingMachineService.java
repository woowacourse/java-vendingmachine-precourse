package vendingmachine.service;


import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Message;
import vendingmachine.utils.Validation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineService {

    private final Validation validation;
    private VendingMachine vendingMachine;

    public VendingMachineService() {
        this.validation = new Validation();
    }

    public void setVendingMachine(){
        int amount = amountValidation();
        int[] coins = makeRandomCoins(amount);
        OutputView.printVendingMachineCoins(coins);
        List<String> products = productValidation();
        this.vendingMachine = new VendingMachine(coins,products);
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



    private int amountValidation(){
        while(true){
            System.out.println(Message.VENDINGMACHINE_INPUT);
            String input = InputView.input();
            try{
                validation.vendingMachinePriceValidation(input);
                return Integer.valueOf(input);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public List<String> productValidation(){
        while(true){
            System.out.println(Message.PRODUCTS_INPUT);
            String input = InputView.input();
            try{
                validation.productPriceValidation(input);
                return Arrays.stream(input.split(";"))
                        .map(product -> product.replaceAll("[\\[\\]]",""))
                        .flatMap(product->Arrays.stream(product.split(",")))
                        .collect(Collectors.toList());
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
