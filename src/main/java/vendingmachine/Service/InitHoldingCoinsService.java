package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Domain.Coin;
import vendingmachine.Domain.HoldingCoins;

public class InitHoldingCoinsService {
    ValidationService validationService = new ValidationService();

    public void setHoldingCoins(String holdingAmount) {
        validationService.isValidHoldingAmount(holdingAmount);
        addPickedCoin(Integer.parseInt(holdingAmount));
    }


    private void addPickedCoin(int amount) {
        while (amount > 0) {
            int pickedAmount = pickRandomCoin(amount);
            amount -= pickedAmount;
            HoldingCoins.addCoin(pickedAmount);
        }
    }

    private int pickRandomCoin(int holdingAmount) {
        int pickedAmount;
        do {
            pickedAmount = Randoms.pickNumberInList(Coin.getAmountList());
        } while (holdingAmount < pickedAmount);

        return pickedAmount;
    }
}
