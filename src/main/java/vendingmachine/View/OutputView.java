package vendingmachine.View;

import vendingmachine.utils.Symbol;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException illegalArgumentException){
        System.out.println(illegalArgumentException.getMessage());
    }

    public void printNewLine() {
        System.out.println(Symbol.NEW_LINE.getSymbol());
    }

}
