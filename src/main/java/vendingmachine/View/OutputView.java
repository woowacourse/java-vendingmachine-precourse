package vendingmachine.View;

import java.util.List;
import java.util.Map;

import vendingmachine.model.Coin;
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

    public void printMachineHaveCoin(final Map<Coin, Integer> machineCoins) {
        System.out.println();
        System.out.println(Messages.MACHINE_HAVE_COINS.getInputMessage());

        String machineHaveCoinPrintFormat = createMachineCoinPrintFormat(machineCoins);

        System.out.println(machineHaveCoinPrintFormat);
    }

    protected String createMachineCoinPrintFormat(final Map<Coin, Integer> machineCoins) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Coin machineCoin : machineCoins.keySet()) {
            stringBuilder.append(machineCoin)
                    .append(Symbol.WON.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(Symbol.DASH.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(machineCoins.get(machineCoin))
                    .append(Symbol.EA.getSymbol())
                    .append(Symbol.NEW_LINE.getSymbol());
        }

        return stringBuilder.toString();
    }

    public void printReturnChange(final int purchasingCost, final List<Integer> returnCoins) {
        printPurChasingCost(purchasingCost);
        System.out.println(CHANGE);
    }

}
