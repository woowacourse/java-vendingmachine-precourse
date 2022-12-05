package vendingmachine.validate;

import vendingmachine.util.ErrorMessage;

public class Validator {
    public static void inputDigitalValidator(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_DIGIT.getMessage());
        }
    }
}
