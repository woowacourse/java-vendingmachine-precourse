package vendingmachine.View;

import java.util.List;

import vendingmachine.utils.Messages;
import vendingmachine.utils.Symbol;

public class OutputView {

    public static final String CHANGE = "잔돈";

    public void printPurChasingCost(int purchasingCost) {
        String purchasingCostPrintFormat = createPurchasingCostPrintFormat(purchasingCost);
        System.out.println(purchasingCostPrintFormat);
    }

    protected String createPurchasingCostPrintFormat(final int purchasingCost) {
        return Symbol.NEW_LINE.getSymbol()
                + Messages.OUTPUT_PURCHASING_COST_MESSAGE.getInputMessage()
                + purchasingCost
                + Symbol.WON.getSymbol();
    }

    public void printMachineHaveCoin(final List<Integer> machineCoins, final List<Integer> coinUnitList) {
        System.out.println();
        System.out.println(Messages.MACHINE_HAVE_COINS.getInputMessage());

        String machineHaveCoinPrintFormat = createMachineCoinPrintFormat(machineCoins, coinUnitList);

        System.out.println(machineHaveCoinPrintFormat);
    }

    protected String createMachineCoinPrintFormat(final List<Integer> machineCoins, final List<Integer> coins) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < machineCoins.size(); i++) {
            stringBuilder.append(coins.get(i))
                    .append(Symbol.WON.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(Symbol.DASH.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(machineCoins.get(i))
                    .append(Symbol.EA.getSymbol())
                    .append(Symbol.NEW_LINE.getSymbol());
        }

        return stringBuilder.toString();
    }

}
