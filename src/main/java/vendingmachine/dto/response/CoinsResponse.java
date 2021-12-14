package vendingmachine.dto.response;

import static vendingmachine.StringConstants.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

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
        return convertToPrint(numberOfCoin -> true);
    }

    public String convertChangeToPrint() {
        int numberOfNoCoin = 0;
        return convertToPrint(numberOfCoin -> numberOfCoin > numberOfNoCoin);
    }

    private String convertToPrint(CoinConditionToIncludeInPrinting condition) {
        Coin.getAlCoinUnitsFromLargestToSmallest().forEach(coinUnit -> convertToPrintByUnit(coinUnit, condition));
        return String.join(NEW_LINE, response);
    }

    private void convertToPrintByUnit(Coin coinUnit, CoinConditionToIncludeInPrinting condition) {
        int count = coins.count(coinUnit);
        if (condition.test(count)) {
            convertToPrintByUnit(coinUnit, count);
        }
    }

    private void convertToPrintByUnit(Coin coinUnit, int count) {
        response.add(writeResponse(coinUnit, count));
    }

    private StringBuilder writeResponse(Coin coinUnit, int count) {
        StringBuilder coinResult = new StringBuilder();
        coinResult.append(coinUnit.getAmount());
        coinResult.append(MONETARY_UNIT_OF_KOREA);
        coinResult.append(DELIMITER);
        coinResult.append(count);
        coinResult.append(UNIT_OF_NUMBER_OF_COIN);
        return coinResult;
    }

    interface CoinConditionToIncludeInPrinting {
        boolean test(int numberOfCoin);
    }
}
