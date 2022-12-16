package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final List<Product> products;

    private Coin coin;

    public VendingMachine(String productGroup) {
        products = setProducts(productGroup);
    }

    public List<Product> setProducts(String productGroup){
        List<String> parsedGroup = parseProductGroup(productGroup);
        return parsedGroup.stream().map(Product::new).collect(Collectors.toList());
    }

    public List<String> parseProductGroup(String productGroup){
        String[] split = productGroup.split(";");
        return Arrays.stream(split).collect(Collectors.toList());
    }

}
