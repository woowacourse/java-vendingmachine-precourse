package vendingmachine;

public class Validation {
    private Message message = new Message();

    public boolean isValidateNumber(String input) {
        try {
            isSpace(input);
            isNumber(input);
            isPositive(input);
            return true;
        } catch (IllegalArgumentException e) {
            message.printInputNumber();
            return false;
        }
    }

    private void isSpace(String input) throws IllegalArgumentException {
        String noSpace = input.replaceAll(" ", "");
        if (noSpace.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumber(String input) throws IllegalArgumentException {
        for (String s : input.split("")) {
            char c = s.charAt(0);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isPositive(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
