package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMachineMoney(){
        System.out.println("자판기가 보유하고 있는 금액을 입략해 주세요");
        return Console.readLine();
    }
}
