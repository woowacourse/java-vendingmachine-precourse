package vendingmachine.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_FORMAT_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.InputItemDTO;

public class ConsoleInputView implements InputView {
    private static final String VENDING_MACHINE_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ITEMS_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String CUSTOMER_MONEY_INPUT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String WANTED_ITEM_NAME_INPUT_MESSAGE = "구매할 상품명을 입력해 주세요.";

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String ITEM_DELIMITER = ";";
    private static final String ITEM_PROPERTY_DELIMITER = ",";
    private static final String LEFT_ITEM_PROPERTIES_BRACKET = "[";
    private static final String RIGHT_ITEM_PROPERTIES_BRACKET = "]";

    @Override
    public String inputVendingMachineMoney() {
        System.out.println(VENDING_MACHINE_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public String inputCustomerMoney() {
        System.out.println(CUSTOMER_MONEY_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public String inputWantedItemName() {
        System.out.println(WANTED_ITEM_NAME_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public void showErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    @Override
    public List<InputItemDTO> inputItemInfos() {
        System.out.println(ITEMS_INPUT_MESSAGE);
        String userInput = readLine();
        return generateInputItemDTOs(userInput);
    }

    private List<InputItemDTO> generateInputItemDTOs(final String itemInfosInput) {
        validateDelimiter(itemInfosInput, ITEM_DELIMITER);
        return Arrays.stream(itemInfosInput.split(ITEM_DELIMITER))
                .map(this::generateInputItemDTO)
                .collect(Collectors.toList());
    }

    private void validateDelimiter(final String source, final String delimiter) {
        String firstLetter = String.valueOf(source.charAt(0));
        String lastLetter = String.valueOf(source.charAt(source.length() - 1));
        String consecutiveItemDelimiter = delimiter + delimiter;
        if (firstLetter.equals(delimiter) || lastLetter.equals(delimiter)
                || source.contains(consecutiveItemDelimiter)) {
            throwIncorrectDelimiterException(delimiter);
        }
    }

    private void throwIncorrectDelimiterException(final String delimiter) {
        if (delimiter.equals(ITEM_DELIMITER)) {
            throw new IllegalArgumentException(WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE);
        } else if (delimiter.equals(ITEM_PROPERTY_DELIMITER)) {
            throw new IllegalArgumentException(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private InputItemDTO generateInputItemDTO(final String itemInfo) {
        String bracketRemovedItemInfo = removeBracket(itemInfo);
        validateDelimiter(bracketRemovedItemInfo, ITEM_PROPERTY_DELIMITER);
        List<String> itemProperties = Arrays.stream(bracketRemovedItemInfo.split(ITEM_PROPERTY_DELIMITER))
                .collect(Collectors.toList());
        return new InputItemDTO(itemProperties);
    }

    private String removeBracket(final String item) {
        String firstLetter = String.valueOf(item.charAt(0));
        String lastLetter = String.valueOf(item.charAt(item.length() - 1));
        if (!firstLetter.equals(LEFT_ITEM_PROPERTIES_BRACKET)
                || !lastLetter.equals(RIGHT_ITEM_PROPERTIES_BRACKET)) {
            throw new IllegalArgumentException(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
        }
        return item.replace(LEFT_ITEM_PROPERTIES_BRACKET, "")
                .replace(RIGHT_ITEM_PROPERTIES_BRACKET, "");
    }
}
