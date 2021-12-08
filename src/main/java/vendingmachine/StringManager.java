package vendingmachine;

public class StringManager {
    public StringManager(){};

    public int toAmount(String amountString){
        int amount;
        try {
            amount = Integer.parseInt(amountString);

            if(amount % 10>0){
                throw new IllegalArgumentException();
            }
            return amount;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
