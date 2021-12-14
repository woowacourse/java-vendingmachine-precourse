package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.repository.ChangeRepository;
import vendingmachine.repository.MachineCoinRepository;
import vendingmachine.view.InputViews;

import java.util.TreeMap;

import static vendingmachine.domain.Coin.getCoinList;
import static vendingmachine.service.Validator.*;
import static vendingmachine.view.OutputViews.printErrorMessage;

public class ChangeService {
    private final ChangeRepository changeRepository = ChangeRepository.getInstance();
    private final MachineCoinRepository machineCoinRepository = MachineCoinRepository.getInstance();

    public void getInitUserChange() {
        while (true) {
            String input = InputViews.inputUserMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                changeRepository.initChange(inputMoney);
                return;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public int getCurrentChange() {
        return changeRepository.getChange();
    }

    public TreeMap<Coin, Integer> getFinalChange() {
        TreeMap<Coin, Integer> finalChange = new TreeMap<Coin, Integer>();
        for (Coin coin : getCoinList()) {
            int coinNum = calculateReturnCoinNum(coin);
            if (coinNum == 0) {
                continue;
            }
            finalChange.put(coin, coinNum);
            changeRepository.subtractChange(coinNum * coin.getAmount());
        }
        return finalChange;
    }

    private int calculateReturnCoinNum(Coin coin) {
        int maxCoinNum = changeRepository.getChange() / coin.getAmount();
        int existCoinNum = machineCoinRepository.getNumOfCoin(coin);
        if (maxCoinNum <= 0) {
            return 0;
        }
        if (existCoinNum > maxCoinNum) {
            return maxCoinNum;
        }
        if (existCoinNum < maxCoinNum) {
            return existCoinNum;
        }
        return 0;
    }
}
