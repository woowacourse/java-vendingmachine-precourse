package vendingmachine;

import java.util.*;

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
}
