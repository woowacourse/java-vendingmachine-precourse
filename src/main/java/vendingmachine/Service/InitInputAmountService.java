package vendingmachine.Service;

import vendingmachine.Domain.InputAmount;
import vendingmachine.Validation.InputAmountValidation;

public class InitInputAmountService {
    InputAmountValidation validation = new InputAmountValidation();

    public void setInputAmount(String inputAmount) {
        validation.isValidInputAmount(inputAmount);
        InputAmount.setInputAmount(Integer.parseInt(inputAmount));
    }

}
