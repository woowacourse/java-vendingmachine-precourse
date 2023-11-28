package service;

import domain.*;
import dto.CoinsDto;
import dto.VendingMachineStatusDto;
import repository.UserPaymentRepository;
import repository.VendingMachineRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineService {

    private static final int REMAINING_BALANCE_WHEN_ALL_COINS_GENERATED = 0;

    private final VendingMachineRepository vendingMachineRepository = VendingMachineRepository.getInstance();

    private final UserPaymentRepository userPaymentRepository = UserPaymentRepository.getInstance();

    public CoinsDto getCurrentCoins() {
        Map<Coin, Integer> coins = vendingMachineRepository.findAll();
        return CoinsDto.from(coins);
    }

    public void generateRandomCoins(int possessionAmount) {

        while (possessionAmount > REMAINING_BALANCE_WHEN_ALL_COINS_GENERATED) {
            Coin randomCoin = Coin.pickRandomWithLimit(possessionAmount);

            vendingMachineRepository.addCoins(randomCoin, 1);

            possessionAmount = possessionAmount - randomCoin.getAmount();
        }
    }

    public CoinsDto getChange() {
        Map<Coin, Integer> changeCoins = new HashMap<>();
        int remainingBalance = userPaymentRepository.get().getPayment();

        for (Coin coin : Coin.values()) {
            int quantity = getCoinQuantityForChange(coin, remainingBalance);
            changeCoins.put(coin, quantity);

            remainingBalance = remainingBalance - (coin.getAmount() * quantity);
        }

        return CoinsDto.from(changeCoins);
    }

    private int getCoinQuantityForChange(Coin coin, int balance) {
        int maxCoinQuantityForChange = getMaxCoinQuantityForChange(coin, balance);
        int holdingQuantity = vendingMachineRepository.findByCoin(coin);

        return Math.min(maxCoinQuantityForChange, holdingQuantity);
    }

    private int getMaxCoinQuantityForChange(Coin coin, int balance) {
        return balance / coin.getAmount();
    }

}

