package vendingmachine.View;

import vendingmachine.Model.Coin;
import vendingmachine.Model.MachineCoin;

import java.util.Map;

public class Computer {

    public void MSGInputMachineCoin(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void PrintMachineCoin(MachineCoin machineCoin){
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> machineCoinMap = machineCoin.getMachineCoin();
        for(Map.Entry<Coin,Integer> m : machineCoinMap.entrySet()){
            System.out.println(m.getKey().getAmount() + "원 - " + m.getValue() + "개");
        }
    }

    public void MSGInputProduct(){
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public void MSGInputAmount(){
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public void MSGCurrentAmount(int currentAmount) {
        System.out.println("투입 금액: " + currentAmount + "원");
    }

    public void MSGInputPurchase(){
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

}
