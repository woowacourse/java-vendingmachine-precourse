package vendingmachine.management;

import vendingmachine.management.validation.CheckDepositFigure;
import vendingmachine.view.InputView;
import vendingmachine.view.outputView.ManagementView;

public class ManagementController {
    protected static int deposit;
    
    public static void runManagement(InputView inputView) {
        ManagementView.askDepositAmout();
        doDepositValidation(inputView);
        ManagementService.generateCoins(deposit);
        ManagementView.showCoinStatus();
       
    }
    
    private static void doDepositValidation(InputView inputView) {
        while(true) {
            String input = inputView.depositAmout();
            
            try {
                CheckDepositFigure.validationFigure(input);
                deposit = Integer.parseInt(input);
                CheckDepositFigure.validationPositiveNumber(deposit);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
