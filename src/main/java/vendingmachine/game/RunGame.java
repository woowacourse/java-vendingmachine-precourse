package vendingmachine.game;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import vendingmachine.model.Coin;
import vendingmachine.util.Constant;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class RunGame {
    private static int vendingmachineholdingPrice;

    public static void run(){
        checkVendingMachinePrice();
        OutputView.showCoins(vendingmachineholdingPrice);
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
        vendingmachineholdingPrice = InputView.parseInt(input);
    }



}
