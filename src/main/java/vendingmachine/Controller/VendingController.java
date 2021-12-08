package vendingmachine.Controller;

import vendingmachine.View.InputView;
import vendingmachine.Model.*;
import java.util.List;

public class VendingController {
    private static InputView inputView;

    public VendingController(InputView inputView){
        this.inputView=inputView;
    }

    public static void start(){
        int balance=getBalance();
        /*
        Coins coins=decideCoins(balance);
        VendingMachine vendingMachine=new VendingMachine(balance, coins);
        */


    }
    private static int getBalance(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Integer.parseInt(inputView.getInput());
    }
    /*
    private static Coins decideCoins(int money){

    }
    */
}
