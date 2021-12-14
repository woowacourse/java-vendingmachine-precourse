package vendingmachine;

import java.util.Map;

public class Computer {

    public void MSGInputMachineCoin(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void PrintMachineCoin(MachineCoin machineCoin){
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> machineCoinMap = machineCoin.getMachineCoin();
        for(Map.Entry<Coin,Integer> m : machineCoinMap.entrySet()){
            System.out.println(m.getKey() + "원 - " + m.getValue() + "개");
        }
    }
}
