package vendingmachine.view.output;

import java.util.Map;

public interface OutputView {
    void showRemainingInputMoney(final int remainingInputMoney);

    void showVendingMachineOwningCoins(final Map<Integer, Integer> kindOfCoinAndNumberOfCoins);

    void showChanges(final Map<Integer, Integer> kindOfCoinAndNumberOfCoins);
}
