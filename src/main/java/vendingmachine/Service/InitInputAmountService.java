package vendingmachine.Service;

import vendingmachine.Domain.VendingMachine;
import vendingmachine.Validation.InputAmountValidation;

public class InitInputAmountService {
    InputAmountValidation validation = new InputAmountValidation();

    public void setInputAmount(String inputAmount) {
        validation.isValidInputAmount(inputAmount);
        VendingMachine.inputMoney(Integer.parseInt(inputAmount));
    }

}
