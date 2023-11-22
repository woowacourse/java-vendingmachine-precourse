package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.constants.Coin;
import vendingmachine.dto.ChangeDTO;

public class CoinManager {
    private final Map<Coin, Integer> coinStatus;

    public CoinManager() {
        this.coinStatus = new EnumMap<>(Coin.class);
    }

    public void initCoin(int machineMoney) {
        Arrays.stream(Coin.values())
                .forEach(val -> coinStatus.put(val, 0));
        while (machineMoney != 0) {
            machineMoney = generateCoins(machineMoney);
        }
    }

    private int generateCoins(int machineMoney) {
        List<Integer> available = Arrays.stream(Coin.values())
                .map(Coin::getValue)
                .filter(value -> machineMoney > value)
                .toList();

        int picked = Randoms.pickNumberInList(available);
        int amount = machineMoney / picked;
        coinStatus.replace(Coin.getCoinByValue(picked), amount);
        return machineMoney - (picked * amount);
    }

    public ChangeDTO getOwnCoinStatus() {
        return new ChangeDTO(coinStatus);
    }

    public ChangeDTO getChangeInfo(int remain) {
        Map<Coin, Integer> changeInfo = new EnumMap<>(Coin.class);

        List<Entry<Coin, Integer>> entries = coinStatus.entrySet()
                .stream().filter(entry -> entry.getValue() != 0)
                .toList();

        for (Entry<Coin, Integer> entry : entries) {
            int amount = remain / entry.getKey().getValue();
            Integer coinAmount = coinStatus.get(entry.getKey()); // 자판기가 실제로 보유하고 있는 동전의 개수

            if (coinAmount >= amount) {
                remain -= entry.getKey().getValue() * amount;
                changeInfo.put(entry.getKey(), amount);
                continue;
            }
            remain -= entry.getKey().getValue() * coinAmount;
            changeInfo.put(entry.getKey(), coinAmount);
        }
        return new ChangeDTO(changeInfo);
    }
}
