package repository;

import domain.Coin;
import domain.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineRepository {
    private static final VendingMachineRepository vendingMachineRepository = new VendingMachineRepository();
    private VendingMachine vendingMachine;

    private VendingMachineRepository() {
        vendingMachine = new VendingMachine();
    }

    public static VendingMachineRepository getInstance() {
        return vendingMachineRepository;
    }

    public void addCoins(Coin coin, int coinQuantity) {
        vendingMachine.addCoins(coin, coinQuantity);
    }

    public int findByCoin(Coin coin) {
        return vendingMachine.findByCoin(coin);
    }

    public Map<Coin, Integer> findAll() {
        return vendingMachine.findAll();
    }
}
