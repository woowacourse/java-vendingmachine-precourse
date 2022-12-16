package model;

import exception.ErrorMessage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Product {

    private static final Pattern PATTERN = Pattern.compile("^[0-9]+$");
    private String name;
    private int price;
    private int total;

    public Product(String product) {
        validateFormat(product);
        List<String> parsedProduct = parsedProduct(product);
        validateNumber(parsedProduct.get(1),parsedProduct.get(2));
        validatePrice(parsedProduct.get(1));
        this.name = parsedProduct.get(0);
        this.price = Integer.parseInt(parsedProduct.get(1));
        this.total = Integer.parseInt(parsedProduct.get(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (price != product.price) return false;
        if (total != product.total) return false;
        return Objects.equals(name, product.name);
    }


    public void validatePrice(String product){
        validatePriceMinimum(product);
        validatePriceUnit(product);
    }

    public void validateFormat(String product){
        if(isCorrectFormat(product)){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private boolean isCorrectFormat(String product) {
        return isCorrectFormatBracket(product) && isCorrectFormatComma(product);
    }

    public boolean isCorrectFormatBracket(String format){
        return format.startsWith("[") && format.endsWith("]");
    }

    public boolean isCorrectFormatComma(String format){
        String[] split = format.split(",");
        return split.length == 3;
    }

    public void validateNumber(String price,String total) {
        if (isNumber(price) && isNumber(total)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_NUMBER_ERROR_MESSAGE.getMessage());
    }

    public boolean isNumber(String string) {
        Matcher matcher = PATTERN.matcher(string);
        return matcher.matches();
    }

    public List<String> parsedProduct(String product){
        String substring = product.substring(1, product.length() - 1);
        String[] split = substring.split(",");
        return Arrays.stream(split).collect(Collectors.toList());
    }

    public void validatePriceMinimum(String price){
        if(Integer.parseInt(price)>=100){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_PRICE_MINIMUM_ERROR_MESSAGE.getMessage());
    }

    public void validatePriceUnit(String price){
        if(Integer.parseInt(price)%10==0){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_UNIT_ERROR_MESSAGE.getMessage());
    }
}
