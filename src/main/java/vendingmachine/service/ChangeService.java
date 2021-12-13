package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.repository.ChangeRepository;
import vendingmachine.view.InputViews;

import java.util.TreeMap;

import static vendingmachine.domain.Coin.*;
import static vendingmachine.repository.ChangeRepository.*;
import static vendingmachine.repository.MachineCoinRepository.getNumOfCoin;
import static vendingmachine.service.Validator.*;
import static vendingmachine.view.OutputViews.printErrorMessage;

public class ChangeService {

    public void getInitUserChange() {
        while (true) {
            String input = InputViews.inputUserMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                initChange(inputMoney);
                return;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public static int getCurrentChange() {
        return getChange();
    }

    public static TreeMap<Coin, Integer> getFinalChange() {
        TreeMap<Coin, Integer> finalChange = new TreeMap<Coin, Integer>();
        for (Coin coin : getCoinList()) {
            int coinNum = calculateReturnCoinNum(coin);
            if (coinNum == 0) {
                continue;
            }
            finalChange.put(coin, coinNum);
            subtractChange(coinNum * coin.getAmount());
        }
        return finalChange;
    }

    private static int calculateReturnCoinNum(Coin coin) {
        int maxCoinNum = getChange() / coin.getAmount();
        int existCoinNum = getNumOfCoin(coin);
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
