package vendingmachine.view.output;

import java.util.Map;

public interface OutputView {
    void showRemainingInputMoney(final int remainingInputMoney);

    void showChanges(final Map<Integer, Integer> kindOfCoinAndNumberOfCoins);
}
