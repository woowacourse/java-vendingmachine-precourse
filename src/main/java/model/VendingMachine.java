package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(String productGroup) {
        products = new ArrayList<>();
    }

    public void va(List<String> parsedGroup){
        List<Product> products = new ArrayList<>();
//        parsedGroup.stream().map()
    }

    public List<String> parseProductGroup(String productGroup){
        String[] split = productGroup.split(";");
        return Arrays.stream(split).collect(Collectors.toList());
    }

}
