package vendingmachine.utils;

import static vendingmachine.validator.ProductFormatValidator.validateFields;
import static vendingmachine.validator.ProductFormatValidator.validateProductFormat;
import static vendingmachine.validator.ProductFormatValidator.validateProductInfo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;

public class ProductParser {

    private static final String INFO_DELIMITER = ",";
    private static final String INFOS_DELIMITER = ";";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_AMOUNT_INDEX = 1;
    private static final int PRODUCT_STOCK_INDEX = 2;
    private static final int INFO_START_INDEX = 1;
    private static final Function<String, Integer> INFO_END_INDEX = s -> s.length() - 2;

    public static List<Product> parse(String formattedInfo) throws IllegalArgumentException {
        return Arrays.stream(formattedInfo.split(INFOS_DELIMITER))
            .map(ProductParser::parseProduct)
            .collect(Collectors.toList());
    }

    private static Product parseProduct(String info) throws IllegalArgumentException {
        validateProductInfo(info);
        String[] fields = info.substring(INFO_START_INDEX, INFO_END_INDEX.apply(info))
            .split(INFO_DELIMITER);
        validateProductFormat(info);
        validateFields(fields);
        return new Product(fields[PRODUCT_NAME_INDEX],
            Integer.parseInt(fields[PRODUCT_STOCK_INDEX]),
            Integer.parseInt(fields[PRODUCT_AMOUNT_INDEX]));
    }

}
