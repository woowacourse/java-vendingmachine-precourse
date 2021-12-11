package vendingmachine.management;

import java.util.Arrays;

import vendingmachine.management.validation.CheckCommodityFormat;
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
        ManagementView.askCommodityInfo();
        prepareCommodity(inputView);
    }
    
    private static void doDepositValidation(InputView inputView) {
        while(true) {
            String input = inputView.depositAmout();
            
            try {
                CheckDepositFigure.validationFigure(input);
                deposit = Integer.parseInt(input);
                CheckDepositFigure.validationPositiveNumber(deposit);
                CheckDepositFigure.validationUnit(deposit);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void prepareCommodity(InputView inputView) {
        while(true) {
            String input = inputView.commodityInfo();
            
            try {
                String [] commodityInfo = input.split(";");
                CheckCommodityFormat.validation(commodityInfo);
                Arrays.stream(commodityInfo).forEach(s -> s.substring(1, s.length()-1));
                putCommodities(commodityInfo);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void putCommodities(String [] commodityInfo) {
        for(String s : commodityInfo) {
            Commodity commodity = ManagementService.toCommodity(s);
            ManagementService.addCommodityInList(commodity);
        }
    }
}
