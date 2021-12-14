package vendingmachine.service;

import static vendingmachine.domain.Message.*;

import java.util.HashSet;

public class InputValidationService {
    private final MessageService messageService = new MessageService();
    private HashSet<String> nameSet = new HashSet<>();

    public boolean isValidateNumber(String input) {
        try {
            isSpace(input);
            isNumber(input);
            isWholeNumbers(input);
            isDivisibleByTen(input);
        } catch (IllegalArgumentException e) {
            messageService.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isValidateProduct(String[] products) {
        for (String s : products) {
            try {
                isInBrackets(s);
                String removedBrackets = removeBrackets(s);
                isFormat(removedBrackets);
                isUniqueName(s);
            } catch (IllegalArgumentException e) {
                messageService.printErrorMessage(e.getMessage());
                nameSet.clear();
                return false;
            }
        }
        return true;
    }

    public boolean isValidateAmount(String input) {
        try {
            isNumber(input);
            isWholeNumbers(input);
        } catch (IllegalArgumentException e) {
            messageService.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private void isUniqueName(String s) throws IllegalArgumentException {
        String[] divided = s.split(",");
        String name = divided[0].substring(1);
        if (nameSet.contains(name)) {
            throw new IllegalArgumentException(ERROR_SAME_PRODUCT_NAME);
        }
        nameSet.add(name);
    }

    private void isSpace(String input) throws IllegalArgumentException {
        String noSpace = input.replaceAll(" ", "");
        if (noSpace.equals("")) {
            throw new IllegalArgumentException(ERROR_SPACE_PRODUCT_NAME);
        }
    }

    private boolean isNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
        return true;
    }

    private boolean isWholeNumbers(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) < 0) {
           throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
        return true;
    }

    private boolean isDivisibleByTen(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % 10 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_TEN);
        }
        return true;
    }

    private void isInBrackets(String input) throws IllegalArgumentException {
        int firstBracketIdx = input.indexOf("[");
        int lastBracketIdx = input.lastIndexOf("]");
        if (firstBracketIdx != 0 || lastBracketIdx != input.length() - 1) {
            throw new IllegalArgumentException(ERROR_NOT_IN_BRACKETS);
        }
    }

    private String removeBrackets(String input) {
        return input.substring(1, input.length() - 1);
    }

    private void isFormat(String input) throws IllegalArgumentException {
        String[] divided = input.split(",");
        isCorrectLength(divided);
        isSpace(divided[0]);
        isCorrectPriceRange(divided[1]);
        isCorrectProductCount(divided[2]);
    }

    private void isCorrectLength(String[] input) throws IllegalArgumentException {
        if (input.length != 3) {
            throw new IllegalArgumentException(ERROR_PRODUCT_FORMAT);
        }
    }

    private void isCorrectPriceRange(String input) throws IllegalArgumentException {
        if (!(isNumber(input) && isDivisibleByTen(input)
                && Integer.parseInt(input) >= 100)) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectProductCount(String input) throws IllegalArgumentException {
        if (!(isNumber(input) && isWholeNumbers(input))) {
            throw new IllegalArgumentException();
        }
    }
}
