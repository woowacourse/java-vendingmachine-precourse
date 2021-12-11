package vendingmachine.dto.response;

import static vendingmachine.StringConstants.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

public class CoinsResponse {
    private static final String DELIMITER = " - ";
    private static final String UNIT_OF_NUMBER_OF_COIN = "개";
    private static final String MONETARY_UNIT_OF_KOREA = "원";

    private final Coins coins;
    private final List<StringBuilder> response = new ArrayList<>();

    public CoinsResponse(Coins coins) {
        this.coins = coins;
    }

    public String convertCoinBalanceToPrint() {
        for(Coin coin: Coin.getAllKindsCoinFromLargestToSmallest()) {
            response.add(writeEachCoinResult(coin, coins.count(coin)));
        }
        return String.join(NEW_LINE, response);
    }

    public String convertChangeToPrint() {
        for(Coin coin: Coin.getAllKindsCoinFromLargestToSmallest()) {
            int count = coins.count(coin);
            int numberOfNoCoin = 0;
            if(count > numberOfNoCoin) {
                response.add(writeEachCoinResult(coin, coins.count(coin)));
            }
        }
        return String.join(NEW_LINE, response);
    }

    private StringBuilder writeEachCoinResult(Coin coin, int numberOfCoin) {
        StringBuilder coinResult = new StringBuilder();
        coinResult.append(coin.getAmount());
        coinResult.append(MONETARY_UNIT_OF_KOREA);
        coinResult.append(DELIMITER);
        coinResult.append(numberOfCoin);
        coinResult.append(UNIT_OF_NUMBER_OF_COIN);
        return coinResult;
    }
}
