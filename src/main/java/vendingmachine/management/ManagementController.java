package vendingmachine.management;

import vendingmachine.management.validation.CheckDepositFigure;
import vendingmachine.view.InputView;
import vendingmachine.view.outputView.ManagementView;

public class ManagementController {
    
    public static void runManagement(InputView inputView) {
        ManagementView.askDepositAmout();
        int deposit = doDepositValidation(inputView.depositAmout());
        ManagementService.generateCoins(deposit);
        ManagementView.showCoinStatus();
       
    }
    
    private static int doDepositValidation(String input) {
        int n = 0;
        
        try {
            n = CheckDepositFigure.validationFigure(input);
            CheckDepositFigure.validationPositiveNumber(n);
            } catch(Exception e) {
                System.out.println(e.getMessage());
        }
        
        return n;
    }
    
}
