package vendingmachine.utils.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInfoValidator {

    private static final String SEMICOLON_SEPARATION_REGEX = "\\s*;\\s*";

    public static List<String> getValidProductInfoList(final String input) {
        List<String> productInfoList = Arrays.stream(input.split(SEMICOLON_SEPARATION_REGEX))
            .collect(Collectors.toList());
        return productInfoList;
    }
}
