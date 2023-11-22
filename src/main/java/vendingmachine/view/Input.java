package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int readAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Integer.parseInt(read());
    }

    private String read() {
        return Console.readLine();
    }
}
