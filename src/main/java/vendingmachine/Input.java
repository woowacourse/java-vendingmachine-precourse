package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputChanges() {
        String input;
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        input = Console.readLine();
        return Integer.parseInt(input);
    }

}
