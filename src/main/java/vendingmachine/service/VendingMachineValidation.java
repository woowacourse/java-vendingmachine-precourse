package vendingmachine.service;

import vendingmachine.utils.Message;
import vendingmachine.utils.Validation;
import vendingmachine.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineValidation {
    private final Validation validation;

    public VendingMachineValidation() {
        this.validation = new Validation();
    }


    public int changeValidation(){
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

    public int inputAmountValidation(){
        while(true){
            System.out.println(Message.AMOUNT_INPUT);
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
