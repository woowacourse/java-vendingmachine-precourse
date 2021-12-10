package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Domain.Coin;
import vendingmachine.Domain.HoldingCoins;

public class InitHoldingCoinsService {

    public void isValidHoldingAmount(String holdingAmount) {
        if (isInteger(holdingAmount) && isInRange(Integer.parseInt(holdingAmount))) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WrongHoldingAmount);
    }

    private boolean isInteger(String holdingAmount) {
        try {
            Integer.parseInt(holdingAmount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isInRange(int holdingAmount) {
        return (holdingAmount >= 0 && holdingAmount % 10 == 0);
    }

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
