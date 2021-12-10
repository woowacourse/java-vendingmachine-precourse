package vendingmachine.dto.response;

import static vendingmachine.StringConstants.NEW_LINE;

public class MoneyAvailableResponse {
    public static final String MONEY_AVAILABLE_NOTICE_PHRASE = "투입 금액: ";
    public static final String MONETARY_UNIT_PHRASE_FOR_MONEY_AVAILABLE_NOTICE = "원";
    private final int moneyAvailable;

    public MoneyAvailableResponse(int moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public StringBuilder toPrint() {
        StringBuilder response = new StringBuilder();
        response.append(NEW_LINE);
        response.append(MONEY_AVAILABLE_NOTICE_PHRASE);
        response.append(moneyAvailable);
        response.append(MONETARY_UNIT_PHRASE_FOR_MONEY_AVAILABLE_NOTICE);
        return response;
    }
}
