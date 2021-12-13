package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class MachineHoldingAmount {
    Coin[] coins = Coin.values();
    Machine machine;
    public int currentAmount = 0;

    public MachineHoldingAmount(Machine machine) {
        this.machine = machine;
    }

    public void setCurrentAmount(int amount) {
        this.currentAmount += amount;
    }

    public int pickRandomCoin() {
        int random = Randoms.pickNumberInList(new ArrayList<Integer>(Arrays.asList(500,100,50,10)));

        return random;
    }

    public boolean checkIsRightRandom(int amount) {
        if (this.currentAmount + amount <= machine.getHoldingAmount()) {
            return true;
        }
        return false;
    }

    public boolean checkIsFullCurrentAmount() {
        return this.currentAmount == machine.getHoldingAmount();
    }

    public Coin compareCoin(int amount) {
        for (Coin coin : coins) {
            if (coin.getCoinAmount() == amount) {
                return coin;
            }
        }
        return coins[0];
    }

    public void makeCoins() {
        while (!checkIsFullCurrentAmount()) {
            int random = pickRandomCoin();
            if (checkIsRightRandom(random)) {
                setCurrentAmount(random);
                compareCoin(random).setCoinNumber();
            }
        }
    }
}
