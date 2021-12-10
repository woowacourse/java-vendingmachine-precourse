package vendingmachine.View;

import vendingmachine.utils.Messages;
import vendingmachine.utils.Symbol;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException illegalArgumentException){
        System.out.println(illegalArgumentException.getMessage());
    }

    public void printCoinCountMessage(){
        System.out.println(Messages.MACHINE_HAVE_COINS.getInputMessage());
    }

    public void printNewLine() {
        System.out.println(Symbol.NEW_LINE.getSymbol());
    }

}
