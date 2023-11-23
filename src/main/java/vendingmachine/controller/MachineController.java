package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        inputView.inputMachineMoney();
    }

    private int inputMachineMoney(){
        boolean flag = false;
        String money = "";
        while(!flag){
            try{
                money = inputView.inputMachineMoney();
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
        return Integer.parseInt(money);
    }
}
