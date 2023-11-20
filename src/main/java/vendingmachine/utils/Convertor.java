package vendingmachine.utils;

import static java.util.regex.Pattern.compile;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class Convertor {
    private static final String PRODUCTS_DELIMITTER = ";";
    private static final String PRODUCT_PREFIX = "[";
    private static final String PRODUCT_SUFFIX = "]";
    private static final String PRODUCT_DELIMITTER = ",";
    private static final String DELIMITTER_EXCEPTION = "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어야 합니다.";
    private static final String PRODUCT_MATCH_REGEX = "\\"+PRODUCT_PREFIX+"^*.*"+"\\"+PRODUCT_SUFFIX+"$";
    private static final Pattern PRODUCT_PATTERN = compile(PRODUCT_MATCH_REGEX);

    public static Products convertToProducts(String input){
        List<String> productSplited = Arrays.stream(input.split(PRODUCTS_DELIMITTER))
                .filter(Convertor::matchProduct)
                .map(product -> product.replace(PRODUCT_PREFIX, "").replace(PRODUCT_SUFFIX, ""))
                .collect(Collectors.toList());
        Map<Product, Integer> products = productSplited.stream()
                .map(Convertor::convertToProduct)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Products.from(products);
    }

    private static boolean matchProduct(final String product) {
        Matcher matcher = PRODUCT_PATTERN.matcher(product);
        if(!matcher.matches()) throw new IllegalArgumentException(DELIMITTER_EXCEPTION);
        return true;
    }

    private static AbstractMap.SimpleEntry<Product, Integer> convertToProduct(String product) {
        String[] productInformation = product.split(PRODUCT_DELIMITTER);
        if(productInformation.length != 3) throw new IllegalArgumentException(DELIMITTER_EXCEPTION);

        String name = productInformation[0];
        int price = covertToInt(productInformation[1]);
        int count = covertToInt(productInformation[2]);

        return new AbstractMap.SimpleEntry<>(Product.of(name, price), count);
    }

    public static int convertToMoney(final String inputString) {
        return covertToInt(inputString);
    }

    private static int covertToInt(String input){
        return Integer.parseInt(input);
    }

}
