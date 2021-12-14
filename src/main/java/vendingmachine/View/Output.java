package vendingmachine.View;

import vendingmachine.Model.Coin;
import vendingmachine.Model.MachineCoin;

import java.util.Map;

import static vendingmachine.Constant.MSGComputer.*;
import static vendingmachine.Constant.MSGComputer.MSG_INPUT_PURCHASE;

public class Output {
    public static void MSGInputMachineCoin(){
        System.out.println(MSG_INPUT_MACHINE_COIN);
    }

    public static void PrintMachineCoin(MachineCoin machineCoin){
        System.out.println(PRINT_MACHINE_COIN);
        Map<Coin, Integer> machineCoinMap = machineCoin.getMachineCoin();
        for(Map.Entry<Coin,Integer> m : machineCoinMap.entrySet()){
            System.out.println(m.getKey().getAmount() + WON + DIVISION + m.getValue() + NUM);
        }
    }

    public static void MSGInputProduct(){
        System.out.println(MSG_INPUT_PRODUCT);
    }

    public static void MSGInputAmount(){
        System.out.println(MSG_INPUT_AMOUNT);
    }

    public static void MSGCurrentAmount(int currentAmount) {
        System.out.println(PRINT_AMOUNT + currentAmount + WON);
    }

    public static void MSGInputPurchase(){
        System.out.println(MSG_INPUT_PURCHASE);
    }

    public static void MSGChanges() {
        System.out.println(MSG_CHANGES);
    }

    public static void PrintChanges(Map<Coin, Integer> changes){
        for(Map.Entry<Coin,Integer> m : changes.entrySet()){
            if(m.getValue() != 0) {
                System.out.println(m.getKey().getAmount() + WON + DIVISION + m.getValue() + NUM);
            }
        }
    }

}
