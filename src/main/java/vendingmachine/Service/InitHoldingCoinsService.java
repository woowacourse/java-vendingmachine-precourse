package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Constant.DomainConstant;
import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Domain.Coin;
import vendingmachine.Domain.HoldingCoins;

public class InitHoldingCoinsService {

    public void setHoldingCoins(String holdingAmount) {
        if (!isValidHoldingAmount(holdingAmount)) {
            throw new IllegalArgumentException(ErrorConstant.WrongHoldingAmount);
        }

        addPickedCoin(Integer.parseInt(holdingAmount));
    }

    private boolean isValidHoldingAmount(String holdingAmount) {
        return (isInteger(holdingAmount) && isInRange(Integer.parseInt(holdingAmount)));
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
        return (holdingAmount >= DomainConstant.MINIMUM_NUMBER_OF_HOLDING_AMOUNT && holdingAmount % DomainConstant.HOLDING_AMOUNT_MUST_BE_DIVIDED == 0);
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
