package vendingmachine.view;

import vendingmachine.domain.Changes;
import vendingmachine.domain.InvestmentMoney;
import vendingmachine.domain.PossessionCoins;

public class OutputView {
    private static final String POSSESSION_COINS_MESSAGE = "\n자판기가 보유한 동전";

    private static final String INVESTMENT_MONEY_FORMAT = "\n투입 금액: %s\n";
    public static final String CHANGES_MESSAGE = "잔돈";

    private OutputView() {
    }

    public static void printPossessionCoins(PossessionCoins possessionCoins) {
        System.out.println(POSSESSION_COINS_MESSAGE);
        possessionCoins.getPossessionCoins().forEach(System.out::println);
    }

    public static void printInvestmentMoney(InvestmentMoney investmentMoney) {
        System.out.printf(INVESTMENT_MONEY_FORMAT, investmentMoney);
    }

    public static void printChanges(Changes changes) {
        System.out.println(CHANGES_MESSAGE);
        changes.getChanges().forEach(System.out::println);
    }
}