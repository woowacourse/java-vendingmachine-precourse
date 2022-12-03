package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public String readCoins(){
        System.out.print("자판기가 보유하고 있는 금액을 입력하세요" + "\n");
        return Console.readLine();
    }
}

