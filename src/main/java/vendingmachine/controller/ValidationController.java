package vendingmachine.controller;

public class ValidationController {
    public static void vendingMachineValidation(String input) {
        isNumValidation(input);
        positiveIntegerValidation(input);
        divided10Validation(input);
    }

    private static void divided10Validation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 10으로 나눠지지 않습니다.");
        }
    }

    private static void positiveIntegerValidation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum < 0){
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다.");
        }
    }

    private static void isNumValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }
}
