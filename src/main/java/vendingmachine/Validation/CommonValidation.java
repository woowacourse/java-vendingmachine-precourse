package vendingmachine.Validation;

public class CommonValidation {
    public boolean isExist(String input) {
        return !(input == null || input.length() == 0);
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isMoreThanNum(int input, int num) {
        return input >= num;
    }

    public boolean isDividedByNum(int input, int num) {
        return input % num == 0;
    }

}
