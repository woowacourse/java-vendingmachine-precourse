package vendingmachine.utils.validator;

import vendingmachine.utils.message.ItemErrorMessage;
import java.util.regex.Pattern;

public class ItemDataValidator implements InputDataValidator {

    private static final int ITEM_INPUT_DATA_COUNT = 3;
    public static final String MULTIPLE_ITEM_SEPARATE_UNIT = ";";
    public static final String SINGLE_ITEM_SEPARATE_UNIT = ",";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private static class InnerInstanceClazz {
        private static final ItemDataValidator instance = new ItemDataValidator();
    }

    public static ItemDataValidator getInstance() {
        return InnerInstanceClazz.instance;
    }

    @Override
    public void validateSingleFormatSize(String data) {
        String[] separatedData = data.split(SINGLE_ITEM_SEPARATE_UNIT);
        if(separatedData.length != ITEM_INPUT_DATA_COUNT) {
            throw new IllegalArgumentException(ItemErrorMessage.INPUT_DATA_COUNT
                    .replaceFirst("count", String.valueOf(ITEM_INPUT_DATA_COUNT)));
        }
    }

    @Override
    public void validateNumber(String data) {
        String[] separatedData = data.split(SINGLE_ITEM_SEPARATE_UNIT);
        if(!Pattern.compile(NUMBER_REGEX).matcher(separatedData[1]).find()){
            throw new IllegalArgumentException(ItemErrorMessage.NUMBER_FORMAT);
        }
        if(!Pattern.compile(NUMBER_REGEX).matcher(separatedData[2]).find()){
            throw new IllegalArgumentException(ItemErrorMessage.NUMBER_FORMAT);
        }
    }

    @Override
    public void validateData(String data) {
        validateSingleFormatSize(data);
        validateNumber(data);
    }
}
