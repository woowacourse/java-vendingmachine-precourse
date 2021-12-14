package vendingmachine.utils.validator;

import vendingmachine.utils.message.ItemErrorMessage;

import java.util.regex.Pattern;

public class MoneyDataValidator implements InputDataValidator {

    private final int MONEY_INPUT_FORMAT_COUNT = 1;
    private final String MONEY_INPUT_SEPARATE_UNIT = " ";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private static class InnerInstanceClazz {
        private static final MoneyDataValidator instance = new MoneyDataValidator();
    }

    public static MoneyDataValidator getInstance() {
        return InnerInstanceClazz.instance;
    }

    @Override
    public void validateSingleFormatSize(String data) {
        String[] separatedData = data.split(MONEY_INPUT_SEPARATE_UNIT);
        if(separatedData.length != MONEY_INPUT_FORMAT_COUNT) {
            throw new IllegalArgumentException(ItemErrorMessage.INPUT_DATA_COUNT
                    .replaceFirst("count", String.valueOf(MONEY_INPUT_FORMAT_COUNT)));
        }
    }

    @Override
    public void validateNumber(String data) {
        if(!Pattern.compile(NUMBER_REGEX).matcher(data).find()){
            throw new IllegalArgumentException(ItemErrorMessage.NUMBER_FORMAT);
        }
    }

    @Override
    public void validateData(String data) {
        validateSingleFormatSize(data);
        validateNumber(data);
    }
}