package vendingmachine;

public class Validation {
    private Message message = new Message();

    public boolean isValidateNumber(String input) {
        try {
            isSpace(input);
            isNumber(input);
            isPositive(input);
            isDivisibleByTen(input);
            return true;
        } catch (IllegalArgumentException e) {
            message.printInputCorrectNumber();
            return false;
        }
    }

    public boolean isValidateProduct(String[] products) {
        for (String s : products) {
            try {
                isInBrackets(s);
                String removedBrackets = removeBrackets(s);
                isFormat(removedBrackets);
                return true;
            } catch (IllegalArgumentException e) {
                message.printInputCorrectFormat();
            }
        }
        return false;
    }

    private void isSpace(String input) throws IllegalArgumentException {
        String noSpace = input.replaceAll(" ", "");
        if (noSpace.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(String input) throws IllegalArgumentException {
        for (String s : input.split("")) {
            char c = s.charAt(0);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private void isPositive(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDivisibleByTen(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % 10 != 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private void isInBrackets(String input) throws IllegalArgumentException {
        int firstBracketIdx = input.indexOf("[");
        int lastBracketIdx = input.indexOf("]");
        if (firstBracketIdx != 0 || lastBracketIdx != input.length() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private String removeBrackets(String input) {
        return input.replace("[", "").replace("]", "");
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
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectPriceRange(String input) throws IllegalArgumentException {
        if (!isNumber(input) || !isDivisibleByTen(input)
                || Integer.parseInt(input) < 100) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectProductCount(String input) throws IllegalArgumentException {
        if (!isNumber(input) || Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
