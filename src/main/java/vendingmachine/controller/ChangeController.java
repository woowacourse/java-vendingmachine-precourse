package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.view.ChangeInputView;
import vendingmachine.view.ChangeOutputView;

public class ChangeController {
    private ChangeInputView changeInputView =  new ChangeInputView();
    private ChangeOutputView changeOutputView  = new ChangeOutputView();
    private Change change;
    /**
     * 1. 현재 보유 금액 입력
     * 2.
     */
    public void insertChange() {
        changeInputView.printInputChange();
        String inputChange = Console.readLine();
        int integerChange = Integer.parseInt(inputChange);
        change = new Change(integerChange);
    }

    public void changeToCoin(){
        change.createRandomCoin();
        changeOutputView.printCoinList(change.getCoinStorage());
    }
}
