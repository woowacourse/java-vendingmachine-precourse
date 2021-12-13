package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputGenerator;
import vendingmachine.util.constant.InputCondition;
import vendingmachine.util.constant.Symbol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MerchandiseValidator implements InputValidator {
    private static final MerchandiseValidator instance = new MerchandiseValidator();
    private String input;

    private MerchandiseValidator() {
    }

    public static MerchandiseValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(String input) {
        this.input = input;
        validateLastStringIsSquareBracket();
        validateContainSpace();
        validateCorrectFormat();
        validateEachItem();
    }

    private void validateLastStringIsSquareBracket() {
        if (!input.endsWith(Symbol.CLOSE_SQUARE_BRACKET)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_EXIST_SQUARE_BUCKET_LAST_STRING.getMessage());
        }
    }

    private void validateContainSpace() {
        if (input.contains(Symbol.SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_CONTAIN_SPACE.getMessage());
        }
    }

    private void validateCorrectFormat() {
        String[] merchandise = InputGenerator.splitBySemiColon(input);

        if (!Arrays.stream(merchandise).allMatch(m -> m.matches(InputCondition.MERCHANDISE_REGEX))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_CORRECT_FORMAT.getMessage());
        }
    }

    private void validateEachItem() {
        String[] merchandise = InputGenerator.splitBySemiColon(input);
        List<String> names = Arrays.stream(merchandise)
                .map(m -> InputGenerator.splitByComma(m.replace(Symbol.OPEN_SQUARE_BRACKET, Symbol.BLANK))[0])
                .collect(Collectors.toList());
        List<String> prices = Arrays.stream(merchandise)
                .map(m -> InputGenerator.splitByComma(m)[1])
                .collect(Collectors.toList());
        List<String> inventories = Arrays.stream(merchandise)
                .map(m -> InputGenerator.splitByComma(m.replace(Symbol.CLOSE_SQUARE_BRACKET, Symbol.BLANK))[2])
                .collect(Collectors.toList());
        validateDuplicateName(names);
        validatePrices(prices);
        validateInventories(inventories);
    }

    private void validateDuplicateName(List<String> names) {
        if (!names.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_DUPLICATE.getMessage());
        }
    }

    private void validatePrices(List<String> prices) {
        prices.forEach(price -> AmountValidator.getInstance().validate(price));
    }

    private void validateInventories(List<String> inventories) {
        inventories.forEach(inventory ->
                validateInventoryRange(InputGenerator.convertToInteger(inventory)));
    }

    private void validateInventoryRange(int inventory) {
        if (inventory < InputCondition.INVENTORY_MIN_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_INVENTORY.getMessage());
        }
    }
}
