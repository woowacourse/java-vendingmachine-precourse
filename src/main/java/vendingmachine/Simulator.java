package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {

    public static final String WON = "원";
    public static final String COUNT = "개";

    public void start() {
        int holdingAmount = inputHoldingAmount();
        CoinContainer coinContainer = new CoinContainer();
        coinContainer.init(holdingAmount);
        printHoldingCoins(coinContainer);
    }

    public int inputHoldingAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String holdingAmount = Console.readLine().trim();
        InputValidator.validateInsertedAmount(holdingAmount);

        return Integer.parseInt(holdingAmount);
    }

    public void printHoldingCoins(CoinContainer coinContainer) {
        String result = "";
        List<Coin> coinList = Arrays.stream(Coin.values())
                                    .sorted(Comparator.comparing(Coin::getAmount).reversed())
                                    .collect(Collectors.toList());
        for (Coin coin : Coin.values()) {
            result += coin.getAmount() + WON + " - " + coinContainer.getCoinCount(coin) + COUNT + "\n";
        }

        System.out.println(result);
    }
}
