package service;

import domain.Coin;
import domain.CoinCountGenerator;
import domain.VendingMachine;
import dto.VendingMachineStatusDto;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineService {

    private final VendingMachine vendingMachine;
    private final CoinCountGenerator coinCountGenerator;

    public VendingMachineService(final VendingMachine vendingMachine, final CoinCountGenerator coinCountGenerator) {
        this.vendingMachine = vendingMachine;
        this.coinCountGenerator = coinCountGenerator;
    }

    public List<VendingMachineStatusDto> generateRandomCoins(int amount) {
        List<VendingMachineStatusDto> statusList = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            CoinCountGenerator coinCountGenerator = new CoinCountGenerator();
            int coinCount = coinCountGenerator.generateRandomCoins(coin, amount);
            vendingMachine.addCoins(coin, coinCount);
            statusList.add(VendingMachineStatusDto.create(coin.getAmount(), coinCount));
            amount -= coin.getAmount() * coinCount;
        }

        return statusList;
    }


}
