package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputInteger() {
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException exception) {
                throw ErrorMessage.NOT_NUMBER.getException();
            }
        }
    }
}
