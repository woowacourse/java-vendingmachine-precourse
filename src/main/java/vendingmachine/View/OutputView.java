package vendingmachine.View;

import java.util.Map;

import vendingmachine.utils.InputOutputMessages;
import vendingmachine.utils.Symbol;

public class OutputView {

    public void printPurChasingCost(int purchasingCost) {
        String purchasingCostPrintFormat = createPurchasingCostPrintFormat(purchasingCost);
        System.out.println(purchasingCostPrintFormat);
    }

    protected String createPurchasingCostPrintFormat(final int purchasingCost) {
        return Symbol.NEW_LINE.getSymbol()
                + InputOutputMessages.OUTPUT_PURCHASING_COST_MESSAGE.getInputMessage()
                + purchasingCost
                + Symbol.WON.getSymbol();
    }

    public void printMachineHaveCoin(final Map<Integer, Integer> machineCoins) {
        System.out.println();
        System.out.println(InputOutputMessages.OUTPUT_MACHINE_HAVE_COINS.getInputMessage());

        String machineHaveCoinPrintFormat = createMachineCoinPrintFormat(machineCoins);

        System.out.println(machineHaveCoinPrintFormat);
    }

    protected String createMachineCoinPrintFormat(final Map<Integer, Integer> machineCoins) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int machineCoin : machineCoins.keySet()) {
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

    public void printReturnChange(final int purchasingCost, final Map<Integer, Integer> returnCoins) {
        printPurChasingCost(purchasingCost);
        System.out.println(Symbol.CHANGE.getSymbol());

        String returnChangePrintFormat = createReturnChangePrintFormat(returnCoins);
        System.out.println(returnChangePrintFormat);
    }

    protected String createReturnChangePrintFormat(final Map<Integer, Integer> returnCoins) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int returnCoin : returnCoins.keySet()) {
            stringBuilder.append(returnCoin)
                    .append(Symbol.WON.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(Symbol.DASH.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(returnCoins.get(returnCoin))
                    .append(Symbol.EA.getSymbol())
                    .append(Symbol.NEW_LINE.getSymbol());
        }

        return stringBuilder.toString();
    }

}
