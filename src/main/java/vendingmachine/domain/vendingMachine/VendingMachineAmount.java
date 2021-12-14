package vendingmachine.domain.vendingMachine;

import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.validator.AmountValidator;

public class VendingMachineAmount {
    private int amount;
    private CoinCombination vendingMachineCoinCombination;

    public VendingMachineAmount(String amount) {
        AmountValidator.checkVendingMachineAmount(amount);
        this.amount = Integer.parseInt(amount);
        generateCoinCombination();
    }

    private void generateCoinCombination() {
        vendingMachineCoinCombination = CoinGenerator.calculatePossibleCoinCombination(amount);
    }

    public CoinCombination getVendingMachineCoinCombination() {
        return vendingMachineCoinCombination;
    }
}
