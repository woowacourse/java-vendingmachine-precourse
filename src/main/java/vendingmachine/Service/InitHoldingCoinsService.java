package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Domain.Coin;
import vendingmachine.Domain.HoldingCoins;

public class InitHoldingCoinsService {

    public void setHoldingCoins(int holdingAmount) {
        while (holdingAmount > 0) {
            int pickedAmount = pickRandomCoin(holdingAmount);
            holdingAmount -= pickedAmount;
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
