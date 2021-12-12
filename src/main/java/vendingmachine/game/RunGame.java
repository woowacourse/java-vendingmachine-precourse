package vendingmachine.game;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.util.Constant;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class RunGame {
    private static int vendingmachineHoldingPrice;

    public static void run(){
        checkVendingMachinePrice();
    }
    private static void checkVendingMachinePrice(){
        try{
            setPrice();
        } catch (IllegalArgumentException e){
            System.out.println(Constant.VENDING_MACHINE_HOLDING_PRICE_ERROR);
            checkVendingMachinePrice();
        }

    }

    private static void setPrice(){
        OutputView.askVendingMachinePrice();
        String input = Console.readLine();
        vendingmachineHoldingPrice = InputView.parseInt(input);

    }
}
