package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.VendingMachineStatusDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final HashMap<Coin, Integer> vendingMachine;

    public VendingMachine(){
        vendingMachine = new HashMap<>();
        init();
    }

    private void init(){
        for (Coin coin : Coin.values()) {
            vendingMachine.put(coin, 0);
        }
    }

    public void addCoins(Coin coin, int count) {
        vendingMachine.put(coin, vendingMachine.get(coin) + count);
    }
}
