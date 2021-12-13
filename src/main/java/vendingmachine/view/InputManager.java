package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String getUserInput(String guide) {
        OutputManager.printMessage(guide);
        String userInput = Console.readLine();
        OutputManager.printBlank();
        return userInput;
    }
}
