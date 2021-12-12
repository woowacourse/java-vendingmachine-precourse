package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VendingMachine {

    Map<Coin, Integer> coinBox;

    public VendingMachine() {
        this.coinBox = new LinkedHashMap<>();
        List<Coin> sortedCoins = Arrays.stream(Coin.values()).sorted().collect(Collectors.toList());
        for (Coin coin : sortedCoins) {
            coinBox.put(coin, 0);
        }
    }

    public void setBaseAsset() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int asset = Integer.parseInt(Console.readLine());
        generateRandomCoinBasedOnAsset(asset);
        announceCoinStock();
    }

    private void generateRandomCoinBasedOnAsset(int asset) {
        Set<Coin> coins = coinBox.keySet();
        while (asset > 0) {
            for (Coin coin : coins) {
                int amount = coin.getCoinValue();
                int maxCoinCount = asset / amount;
                List<Integer> availableNumbers = makeAvailableNumbers(maxCoinCount);
                int randomCoinCount = Randoms.pickNumberInList(availableNumbers);
                asset -= amount * randomCoinCount;
                coinBox.put(coin, randomCoinCount + coinBox.get(coin));
            }
        }
    }

    private List<Integer> makeAvailableNumbers(int maxCoinCount) {
        List<Integer> tempNumbers = new ArrayList<>();
        for (int i = 0; i <= maxCoinCount; i++) {
            tempNumbers.add(i);
        }
        return tempNumbers;
    }

    private void announceCoinStock() {
        System.out.println("\n자판기가 보유한 동전");
        Set<Coin> coins = coinBox.keySet();
        for (Coin coin : coins) {
            System.out.println(coin.getCoinValue() + "원" + " - " + coinBox.get(coin) + "개");
        }
    }
}
