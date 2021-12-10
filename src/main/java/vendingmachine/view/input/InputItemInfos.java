package vendingmachine.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.InputItemDTO;

public class InputItemInfos {
    private static final String WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE = "상품을 구분하는 구분자(;) 앞 뒤에 상품 정보가 없습니다.";
    private static final String ITEM_INFO_FORMAT_EXCEPTION_MESSAGE = "상품 정보가 잘못되었습니다. Format : [상품명,가격,수량]";

    private static final String ITEM_DELIMITER = ";";
    private static final String ITEM_PROPERTY_DELIMITER = ",";
    private static final String LEFT_ITEM_PROPERTIES_BRACKET = "[";
    private static final String RIGHT_ITEM_PROPERTIES_BRACKET = "]";

    public List<InputItemDTO> generateInputItemDTOs(final String itemInfosInput) {
        validateDelimiter(itemInfosInput, ITEM_DELIMITER);
        return Arrays.stream(itemInfosInput.split(ITEM_DELIMITER))
                .map(this::generateInputItemDTO)
                .collect(Collectors.toList());
    }

    private void validateDelimiter(final String inputSource, final String delimiter) {
        String firstLetter = String.valueOf(inputSource.charAt(0));
        String lastLetter = String.valueOf(inputSource.charAt(inputSource.length() - 1));
        String consecutiveItemDelimiter = delimiter + delimiter;
        if (firstLetter.equals(delimiter) || lastLetter.equals(delimiter)
                || inputSource.contains(consecutiveItemDelimiter)) {
            throwException(delimiter);
        }
    }

    private void throwException(final String delimiter) {
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
