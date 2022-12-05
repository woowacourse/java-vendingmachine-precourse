package vendingmachine.validate;

import vendingmachine.util.ErrorMessage;

public class Validator {
    private final String SEPARATE = ",";
    private final String FORMAT_PREFIX = "[";
    private final String FORMAT_SUFFIX = "]";

    public void inputDigitalValidator(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_DIGIT.getMessage());
        }
    }
    public void productFormatValidator(String input){
        if(!(input.startsWith(FORMAT_PREFIX) && input.endsWith(FORMAT_SUFFIX)))
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_FORMAT_EXCEPTION.getMessage());
    }
    public void productInputSizeValidator(String input){
        if(input.split(SEPARATE).length != 3)
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_FORMAT_EXCEPTION.getMessage());
    }

    public void productCountValidator(String input) {
        if(Integer.valueOf(input) < 0)
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_COUNT_UNDER_ZERO.getMessage());
    }
}
