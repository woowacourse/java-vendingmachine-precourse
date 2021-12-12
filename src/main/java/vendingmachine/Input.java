package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputInteger() {
        while (true) {
            return Integer.parseInt(Console.readLine());
        }
    }
}
