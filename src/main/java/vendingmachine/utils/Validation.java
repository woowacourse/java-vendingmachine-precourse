package vendingmachine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Validation {
    public void vendingMachinePriceValidation(String input) {
        checkInputNull(input);
        inputIsNumeric(input);
        inputIsPositive(input);
    }

    public void productValidation(String input) {
        checkInputNull(input);
        List<String> inputList = Arrays.stream(input.split(";"))
                .flatMap(product -> Arrays.stream(product.split(",")))
                .collect(Collectors.toList());
        checkDuplicateProducts(inputList);
        formIsCorrect(inputList);
    }

    public void orderValidation(String input){
        checkInputNull(input);
    }

    private void checkDuplicateProducts(List<String> inputList){
        List<String> nameList = new ArrayList<>();
        for(int i = 0; i < inputList.size(); i+=3){
            nameList.add(inputList.get(i));
        }
        Set<String> removeDuplicateName = nameList.stream()
                .collect(Collectors.toSet());
        if(nameList.size() != removeDuplicateName.size()){
            throw new IllegalArgumentException(Message.ERROR + Message.DUPLICATE_PRODUCT);
        }
    }

    private void checkInputNull(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(Message.ERROR + Message.NULL_INPUT);
        }
    }

    private void inputIsNumeric(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_NOT_NUMERIC);
        }
    }

    private void inputIsPositive(String input) {
        if (Integer.valueOf(input) <= 0) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_NOT_POSITIVE_VALUE);
        }
    }

    private void formIsCorrect(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            String target = inputList.get(i);
            if (i % 3 == 0) {
                startWithBracket(target);
            }

            if (i % 3 == 1) {
                productPriceCheck(target);
            }

            if (i % 3 == 2) {
                endWithBracket(target);
                productQuantityCheck(target);
            }
        }
    }

    private void productPriceCheck(String target) {
        inputIsNumeric(target);
        inputIsPositive(target);
        productPriceIsHigherThan100(target);
        productPriceIsDivisible(target);
    }

    private void productQuantityCheck(String target) {
        inputIsNumeric(target.substring(0, target.length() - 1));
        inputIsPositive(target.substring(0, target.length() - 1));
    }

    private void startWithBracket(String input) {
        if (!input.startsWith("[")) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_NOT_COLLECT_FORM);
        }
    }

    private void endWithBracket(String input) {
        if (!input.endsWith("]")) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_NOT_COLLECT_FORM);
        }
    }

    private void productPriceIsHigherThan100(String input) {
        if (Integer.valueOf(input) < 100) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_LOWER_THAN_100);
        }
    }


    private void productPriceIsDivisible(String input) {
        if (Integer.valueOf(input) % 10 != 0) {
            throw new IllegalArgumentException(Message.ERROR + Message.IS_UNDIVISIBLE);
        }
    }
}
