package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

        String inputText = Console.readLine();
        InputValidator.isVaildMoney(inputText);
        VendingMachineMain.initMachine(Integer.parseInt(inputText));
    }
}