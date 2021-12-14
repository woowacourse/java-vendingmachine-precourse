package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Change {
    private Map<Integer, Integer> changes = new LinkedHashMap<>();

    public Change(int inputChanges) {
        initializeChangeList();
        setRandomChangeList(inputChanges);
        printChangesList();
    }

    public void initializeChangeList() {
        for(int change : Coin.coinList()) {
            changes.put(change, 0);
        }
    }

    public void setRandomChangeList(int holdingChange) {
        while(holdingChange != 0) {
            int randomChange = Randoms.pickNumberInList(Coin.coinList());
            if(randomChange <= holdingChange) {
                holdingChange -= randomChange;
                changes.put(randomChange, changes.get(randomChange) + 1);
            }
        }
    }

    public void printChangesList() {
        System.out.println("자판기가 보유한 동전");
        for (Integer change : changes.keySet()) {
            int count = changes.get(change);
            System.out.println( change + "원" + " - " + count + "개");
        }
    }
}