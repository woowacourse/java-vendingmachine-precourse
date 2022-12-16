package model;

import exception.ErrorMessage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Product {

    private static final Pattern PATTERN = Pattern.compile("\\[(.*?,.*?,.*?)\\]");
    private String name;
    private int price;
    private int total;

    public Product() {

    }

    public void validateProduct(String product){

    }

    public List<String> parsedProductGroup(String product){
        String[] split = product.split(";");
        return Arrays.stream(split).map(s -> s.substring(1, s.length() - 2))
                .collect(Collectors.toList());
    }

    public void validateFormat(String product){
        String[] split = product.split(";");
        if(isCorrectFormat(split)){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private boolean isCorrectFormat(String[] split) {
        return Arrays.stream(split).allMatch(s -> isCorrectFormatBracket(s) && isCorrectFormatComma(s));
    }

    public boolean isCorrectFormatBracket(String format){
        return format.startsWith("[") && format.endsWith("]");
    }

    public boolean isCorrectFormatComma(String format){
        String[] split = format.split(",");
        return split.length == 3;
    }
}
