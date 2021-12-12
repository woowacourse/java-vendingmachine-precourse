package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static vendingmachine.Application.USER_MONEY;
import static vendingmachine.Validation.isUserMoneyAndMachineInventoryEnough;

public class VendingMachine {

    private int machineOwnMoney;

    public VendingMachine(int machineOwnMoney){
        this.machineOwnMoney = machineOwnMoney;
    }


    public static void startVendingMachine(ArrayList<Product> products){
        while(isUserMoneyAndMachineInventoryEnough(products)){
            try {
                purchaseProduct(products);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        changesBack();
    }


    public static HashMap<Integer, Integer> changesBack(){
        HashMap<Integer, Integer> changes = new HashMap<>();
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            findChanges(c, changes);
        }
        printChanges(changes);
        return changes;
    }

    public static void printChanges(HashMap<Integer, Integer> changes){
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(changes.entrySet());
        entryList.sort((o1, o2) -> o2.getKey() - o1.getKey());
        System.out.println("잔");
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(entry.getValue() != 0){
                System.out.println(entry.getKey() + "원 - " + entry.getValue() + "개");
            }
        }
    }

    public static void findChanges(Coin coin, HashMap<Integer, Integer> changes){
        if(coin.getAmount() < USER_MONEY && coin.getCount() > 0 && USER_MONEY >= 10){
            int coinCount = USER_MONEY / coin.getAmount();
            if(USER_MONEY / coin.getAmount() > coin.getCount()){
                coinCount = coin.getCount();
            }
            changes.put(coin.getAmount(), coinCount);
            USER_MONEY -= coinCount * coin.getAmount();
        }
    }


    public static void printCurrentMachineCoin(){
        System.out.println("자판기가 보유한 동전");
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            System.out.println(c.getAmount()+"원 - " + c.getCount()+"개");
        }
    }

    public static void setRandomCountToEachCoin(){
        int tempMachineOwnMoney = MACHINE_OWN_MONEY;
        int selectedCoin;

        while(tempMachineOwnMoney != 0) {
            selectedCoin = Randoms.pickNumberInList(Coin.getCoinList());
            if(tempMachineOwnMoney / selectedCoin > 0){
                Coin.valueOf("COIN_" + selectedCoin).addCount();
                tempMachineOwnMoney -= selectedCoin;
            }
        }
    }

    public static int inputMachineOwnMoney(){
        String machineOwnMoney = "";
        while(machineOwnMoney.isEmpty()) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                machineOwnMoney = Console.readLine();
                inputMachineOwnMoneyAndValidation(machineOwnMoney);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(machineOwnMoney);
    }
}
