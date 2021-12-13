package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.repository.MachineCoinRepository;
import vendingmachine.view.InputViews;

import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;
import static vendingmachine.view.Messages.*;


public class MachineCoinService {

    private MachineCoinRepository machineCoinRepository;

    public static int getInitMachineMoney() {
        while (true) {
            String input = InputViews.inputInitMachineMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkNotString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkPositiveNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    public static void checkDivideByTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_BY_TEN);
        }
    }

    public void initRemainCoin(int initMoney) {
        Map<Coin, Integer> remainCoin= new TreeMap<>();
        for (Coin c : getCoinList()) {
            remainCoin.put(c, 0);
        }
        setRemainCoin(remainCoin, initMoney);
        machineCoinRepository.initCoin(remainCoin);
    }

    private void setRemainCoin(Map<Coin, Integer> remainCoin, int initMoney) {
        int remainMoney = initMoney;
        while (remainMoney > 0) {
            int pickedCoin = pickRandomCoin(remainMoney);
            remainMoney -= pickedCoin;
            remainCoin.put(getEnumCoin(pickedCoin), remainCoin.get(getEnumCoin(pickedCoin)) + 1);
        }
    }

    private static int pickRandomCoin(int remainMoney) {
        return pickNumberInList(getAvailableCoinValueList(remainMoney));
    }
}
