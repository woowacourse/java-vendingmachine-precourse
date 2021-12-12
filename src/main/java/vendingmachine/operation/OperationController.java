package vendingmachine.operation;

import vendingmachine.view.InputView;
import vendingmachine.view.outputView.OperationView;
import vendingmachine.common.CheckMoenyFigure;
import vendingmachine.management.Commodity;
import vendingmachine.management.CommodityRepository;
import vendingmachine.operation.validation.CheckCommoditySelection;

public class OperationController {
    protected static int balance;
    
    public static void runOperation(InputView inputView) {
        OperationView.askInsertionAmount();
        doBalanceValidation(inputView);
       
        OperationView.showBalance(balance);
        OperationView.askCommodity();
        selectCommodity(inputView);
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
    
    private static void selectCommodity(InputView inputView) {
        while(true) {
            String input = inputView.selectCommodity();
            
            try {
                CheckCommoditySelection.validationNotRegistered(input);
                Commodity commodity = CommodityRepository.findByName(input);
                balance = OperationService.calculateBalance(commodity, balance);
                OperationService.reduceCommodityQuantity(commodity);
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
