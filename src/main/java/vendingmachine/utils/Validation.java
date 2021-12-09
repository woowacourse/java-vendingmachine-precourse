package vendingmachine.utils;

public class Validation {
    public void vendingMachinePriceValidation(String input){
        priceIsNumeric(input);
        priceIsPositive(input);
    }

    public void priceIsNumeric(String input){
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException(Message.ERROR + Message.IS_NOT_NUMERIC);
        }
    }

    public void priceIsPositive(String input){
        if(Integer.valueOf(input) <= 0){
            throw  new IllegalArgumentException(Message.ERROR + Message.IS_NOT_POSITIVE_VALUE);
        }
    }
}
