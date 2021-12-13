package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class PrintUI {
    public static int InputChange() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int change = Integer.parseInt(Console.readLine());
        return change;
    }
}
