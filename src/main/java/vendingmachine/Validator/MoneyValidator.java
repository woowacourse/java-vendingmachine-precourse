package vendingmachine.Validator;

public class MoneyValidator {
    public static boolean isValidateMoney(String input) {
        if (!NumberValidator.isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!NumberValidator.isPositiveNumber(inputNumber) || !NumberValidator.isMultipleOfTen(inputNumber)) {
            return false;
        }
        return true;
    }
}
