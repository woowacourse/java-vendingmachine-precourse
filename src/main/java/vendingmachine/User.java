package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private Validation validation = new Validation();

    public int inputHolding() throws IllegalArgumentException {
        while (true) {
            String input = Console.readLine();
            if (validation.isValidateNumber(input)) {
                return Integer.parseInt(input);
            }
        }
    }
}
