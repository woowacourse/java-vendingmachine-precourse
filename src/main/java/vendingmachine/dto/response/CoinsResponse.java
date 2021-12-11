package vendingmachine.dto.response;

import static vendingmachine.StringConstants.NEW_LINE;

import java.util.List;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

public class CoinsResponse {
    private static final String CURRENT_BALANCE_NOTICE_PHRASE = "잔돈";
    private static final String DELIMITER = " - ";
    private static final String UNIT_OF_NUMBER_OF_COIN = "개";
    private static final String MONETARY_UNIT_OF_KOREA = "원";

    private final Coins coins;
    private final StringBuilder response = new StringBuilder();

    public CoinsResponse(Coins coins) {
        this.coins = coins;
    }

    public StringBuilder toPrint() {
        response.append(NEW_LINE);
        response.append(CURRENT_BALANCE_NOTICE_PHRASE);
        for(Coin coin: Coin.getAllKindsCoinFromLargestToSmallest()) {
            response.append(NEW_LINE);
            response.append(writeEachCoinResult(coin, coins.count(coin)));
        }
        return response;
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
