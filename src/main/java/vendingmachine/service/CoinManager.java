package vendingmachine.service;

import static vendingmachine.exception.ErrorCode.INVALID_INPUT_MONEY;

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
        validate(machineMoney);
        //TODO: coinStatus에 값을 할당하는 로직 필요
        //TODO: temp code이므로 삭제  필요
        coinStatus.put(Coin.COIN_100, 4);
        coinStatus.put(Coin.COIN_50, 1);
    }

    private void validate(int machineMoney) {
        if (machineMoney % 10 != 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MONEY.getMessage());
        }
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
