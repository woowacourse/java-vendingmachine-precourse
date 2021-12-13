package vendingmachine.service;

public class OrderValidator {

    public boolean isValidMoney(String money){
        String numericRegex = "[0-9]+";
        return money.matches(numericRegex);
    }
}
