package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.repository.MachineCoinRepository;
import vendingmachine.view.InputViews;

import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;
import static vendingmachine.service.Validator.*;
import static vendingmachine.view.OutputViews.printErrorMessage;

public class MachineCoinService {

    private static MachineCoinRepository machineCoinRepository = MachineCoinRepository.getInstance();
    public static final int INIT_COIN_NUM = 0;

    public int getInitMachineMoney() {
        while (true) {
            String input = InputViews.inputInitMachineMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public void initRemainCoin(int initMoney) {
        Map<Coin, Integer> remainCoin = new TreeMap<>();
        for (Coin c : getCoinList()) {
            remainCoin.put(c, INIT_COIN_NUM);
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

    private int pickRandomCoin(int remainMoney) {
        return pickNumberInList(getAvailableCoinValueList(remainMoney));
    }

    public Map<Coin, Integer> getNumOfCoin() {
        return machineCoinRepository.getNumOfAllCoin();
    }
}
