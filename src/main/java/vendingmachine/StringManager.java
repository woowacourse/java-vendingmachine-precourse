package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class StringManager {
    public StringManager(){};

    private static final int AMOUNT_UNIT=10;
    public int toAmount(String amountString){
        int amount;
        try {
            amount = Integer.parseInt(amountString);
            checkUnitCondition(amount);
            return amount;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private void checkUnitCondition(int amount){
        if(amount%AMOUNT_UNIT>0) {
            throw new IllegalArgumentException();
        }
    }
}
