package vendingmachine.operation;

import vendingmachine.view.InputView;
import vendingmachine.view.outputView.OperationView;
import vendingmachine.common.CheckMoenyFigure;

public class OperationController {
    protected static int balance;
    
    public static void runOperation(InputView inputView) {
        OperationView.askInsertionAmount();
        doBalanceValidation(inputView);
        OperationView.showBalance(balance);
        OperationView.askCommodity();
        
        
    }
    
    private static void doBalanceValidation(InputView inputView) {
        while(true) {
            String input = inputView.insertMoney();
            try {
                CheckMoenyFigure.validationFigure(input);
                balance = Integer.parseInt(input);
                CheckMoenyFigure.validationPositiveNumber(balance);
                CheckMoenyFigure.validationUnit(balance);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    

}
