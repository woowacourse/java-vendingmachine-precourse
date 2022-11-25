package vendingmachine;

import static vendingmachine.Coin.getVendingMachineCoins;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Map<Integer, Integer> vendingMachineCoins = new TreeMap<>(Collections.reverseOrder());

    public void run() {
        initVendingMachine();
        outputView.printVendingMachineCoins(vendingMachineCoins);
    }

    private void initVendingMachine() {
        int vendingMachineCoin = inputView.inputVendingMachineCoinProcess();
        try {
            validateCoin(vendingMachineCoin);
            vendingMachineCoins = getVendingMachineCoins(vendingMachineCoin);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initVendingMachine();
        }
    }

    private void validateCoin(int vendingMachineCoin) {
        if (vendingMachineCoin % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력해야 합니다.");
        }
    }

}
