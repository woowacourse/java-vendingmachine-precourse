package vendingmachine.operation;

import vendingmachine.view.InputView;

import vendingmachine.view.outputView.OperationView;
import vendingmachine.Coin;
import vendingmachine.common.CheckMoenyFigure;
import vendingmachine.management.Commodity;
import vendingmachine.management.CommodityRepository;
import vendingmachine.operation.validation.CheckBalanceReturning;

import java.util.Map;

public class OperationController {
    protected static int balance;
    
    public static void runOperation(InputView inputView) {
        OperationView.askInsertionAmount();
        doBalanceValidation(inputView);
        
        while(true) {
            OperationView.showBalance(balance);
            
            if(CheckBalanceReturning.hasNoBalance(balance) || CheckBalanceReturning.hasNoStock()) {
                returnBalance();
                break;
            }
            OperationView.askCommodity();
            selectCommodity(inputView);
        }      
    }
    
    private static void doBalanceValidation(InputView inputView) {
        while(true) {
            String input = inputView.insertMoney();
            
            try {
                CheckMoenyFigure.validationFigure(input);
                balance = Integer.parseInt(input);
                CheckMoenyFigure.validationPositiveNumber(balance);
                CheckMoenyFigure.validationUnit(balance);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void selectCommodity(InputView inputView) {
        while(true) {
            String input = inputView.selectCommodity();
            
            try {
                Commodity commodity = CommodityRepository.findByName(input);
                balance = OperationService.calculateBalance(commodity, balance);
                OperationService.reduceCommodityQuantity(commodity);  
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void returnBalance() {
        Map<Coin, Integer> map = OperationService.getLeastNumberOfCoin(balance);
        OperationView.showBalanceReturn(map);
    } 
}
