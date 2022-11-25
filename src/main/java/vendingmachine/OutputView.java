package vendingmachine;

import static vendingmachine.MessageUtils.ERROR;

public class OutputView {

    public void printErrorMessage(String errorMsg){
        System.out.println(ERROR.msg() + " " + errorMsg);
    }
}
