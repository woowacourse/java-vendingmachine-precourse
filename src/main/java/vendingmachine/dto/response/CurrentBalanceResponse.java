package vendingmachine.dto.response;

import static vendingmachine.StringConstants.NEW_LINE;

import vendingmachine.Coins;

public class CurrentBalanceResponse {
    private static final String CURRENT_BALANCE_NOTICE_PHRASE = "자판기가 보유한 동전";
    private static final String DELIMITER = " - ";
    private static final String UNIT_OF_NUMBER_OF_COIN = "개";
    private static final String COIN500_KOREAN = "500원";
    private static final String COIN100_KOREAN = "100원";
    private static final String COIN50_KOREAN = "50원";
    private static final String COIN10_KOREAN = "10원";

    private final Coins currentBalance;
    private final StringBuilder response = new StringBuilder();

    public CurrentBalanceResponse(Coins currentBalance) {
        this.currentBalance = currentBalance;
    }

    public StringBuilder toPrint() {
        response.append(NEW_LINE);
        response.append(CURRENT_BALANCE_NOTICE_PHRASE);
        response.append(NEW_LINE);
        response.append(addCoinResult(COIN500_KOREAN, currentBalance.countCoin500()));
        response.append(NEW_LINE);
        response.append(addCoinResult(COIN100_KOREAN, currentBalance.countCoin100()));
        response.append(NEW_LINE);
        response.append(addCoinResult(COIN50_KOREAN, currentBalance.countCoin50()));
        response.append(NEW_LINE);
        response.append(addCoinResult(COIN10_KOREAN, currentBalance.countCoin10()));
        return response;
    }

    private StringBuilder addCoinResult(String coinToKorean, int numberOfCoin) {
        StringBuilder coin500Response = new StringBuilder();
        coin500Response.append(coinToKorean);
        coin500Response.append(DELIMITER);
        coin500Response.append(numberOfCoin);
        coin500Response.append(UNIT_OF_NUMBER_OF_COIN);
        return coin500Response;
    }
}
