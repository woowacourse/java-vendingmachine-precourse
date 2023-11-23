package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import vendingmachine.domain.constant.Coin;

public class CoinGenerator {
    public static EnumMap<Coin, Integer> vendingMachineCoinGeneration(int coin) {
        // EnumMap을 사용하여 동전들을 저장
        EnumMap<Coin, Integer> coinMap = new EnumMap<>(Coin.class);

        // 남은 금액이 0이 될 때까지 동전을 선택하고 EnumMap에 추가
        while (coin > 0) {
            Coin selectedCoin = getRandomCoin();
            int selectedCoinValue = selectedCoin.getAmount();

            // 남은 금액보다 큰 가치의 동전을 선택하지 않도록 확인
            if (selectedCoinValue <= coin) {
                coinMap.merge(selectedCoin, 1, Integer::sum);
                coin -= selectedCoinValue;
            }
        }

        return coinMap;
    }

    // EnumMap의 key로 사용할 Coin을 무작위로 선택하는 메서드
    private static Coin getRandomCoin() {
        Coin[] coins = Coin.values();
        List<Integer> coinValues = Arrays.stream(coins)
                .map(Coin::getAmount)
                .toList();

        int randomIndex = Randoms.pickNumberInList(coinValues);
        return coins[randomIndex];
    }
}

