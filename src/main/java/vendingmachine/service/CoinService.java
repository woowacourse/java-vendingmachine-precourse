package vendingmachine.service;

import vendingmachine.domain.Coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class CoinService {
    public int[] makeRandomCoins(int amount) {
        List<Integer> randomCoinList = new ArrayList<>();
        while (amount > 0) {
            int pickedCoin = pickCoin(amount);
            amount -= pickedCoin;
            randomCoinList.add(pickedCoin);
        }

        int[] frequencyList = countFrequency(randomCoinList);

        return frequencyList;
    }


    public int pickCoin(int amount) {
        List<Coin> possibleCoinList = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            if (isPossible(amount, coin)) {
                possibleCoinList.add(coin);
            }
        }
        int pickedCoin = pickNumberInList(convertAmountList(possibleCoinList));
        return pickedCoin;
    }


    public int[] countFrequency(List<Integer> randomCoinList) {
        int[] frequencyList = new int[4];
        int[] coinList = coinAmountList;
        for (int i = 0; i < 4; i++) {
            frequencyList[i] = Collections.frequency(randomCoinList, coinList[i]);
        }
        return frequencyList;
    }

    public int compareCoin(int needCoin, int haveCoin) {
        if (needCoin > haveCoin) {
            return haveCoin;
        }
        return needCoin;
    }

}
