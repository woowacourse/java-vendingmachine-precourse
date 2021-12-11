package vendingmachine;

public class Validator {
    public static void validateInputCash(String buffer) throws MyIllegalArgumentException {
        for (char c : buffer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Input must be a positive integer value");
            }
        }

        if (buffer.length() > 5) {
            throw new MyIllegalArgumentException("Input value shouldn't be larger than 99999");
        }
    }
}
