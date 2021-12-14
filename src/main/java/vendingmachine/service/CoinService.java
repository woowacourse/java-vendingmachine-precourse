package vendingmachine.service;

import static vendingmachine.constants.SystemConstants.NO_TOTAL_MONEY_LEFT;
import static vendingmachine.constants.SystemConstants.ZERO_COINS;
import static vendingmachine.utils.NumberInputValidator.validateMoneyInput;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.HashMap;

public class CoinService {

    private final HashMap<Coin, Integer> coins = new HashMap<>();

    public HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public void initializeCoins() {
        for (Coin coin : Coin.values()) {
            this.coins.put(coin, ZERO_COINS);
        }
        generateCoins(this.getVendingMachineMoneyInput());

        OutputView.printCoinsInfo(this.coins);
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > NO_TOTAL_MONEY_LEFT) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmountDesc());
            if (totalMoney >= randomCoinAmount) {
                Coin newCoin = Coin.getCoinByAmount(randomCoinAmount);
                coins.put(newCoin, coins.get(newCoin) + 1);
                totalMoney -= randomCoinAmount;
            }
        }
    }

    private int getVendingMachineMoneyInput() {
        try {
            String input = InputView.requestVendingMachineMoneyInput();
            validateMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getVendingMachineMoneyInput();
        }
    }
}
