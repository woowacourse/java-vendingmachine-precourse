package vendingmachine.View;

import vendingmachine.utils.Messages;
import vendingmachine.utils.Symbol;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printPurChasingCost(int purchasingCost) {
        System.out.println(Messages.INPUT_PURCHASING_COST.getInputMessage() + purchasingCost + Symbol.WON.getSymbol());
    }

}
