package validator;

import vendingmachine.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductValidator {
    private static final String DELIMITER = ",";

    private static final int SUBSTRING_INDEX = 1;

    public static String validateInput(String input) {
        return input.replaceAll("\\[","").replaceAll("]","");
    }
}
