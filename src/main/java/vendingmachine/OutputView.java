package vendingmachine;

import static vendingmachine.MessageUtils.INPUT_MACHINE_MONEY;

public class OutputView {
    private static final String ERROR = "[ERROR]";

    public void printErrorMessage(String errorMsg){
        System.out.println(ERROR + " " + errorMsg);
    }

    public void printMachineMoneyInputOpening(){
        System.out.println(INPUT_MACHINE_MONEY.msg());
    }
}
