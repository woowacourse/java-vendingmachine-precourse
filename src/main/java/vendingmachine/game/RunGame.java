package vendingmachine.game;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.util.Constant;
import vendingmachine.view.OutputView;

public class RunGame {

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

    }
}
