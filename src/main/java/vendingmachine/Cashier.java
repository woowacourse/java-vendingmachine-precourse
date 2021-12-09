package vendingmachine;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자판기의 동전을 관리하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Cashier {
	public void makeCoins(int holdingAmount) {
		do {
			int coinAmount = Randoms.pickNumberInList(Coin.getAmounts());
			if (coinAmount <= holdingAmount) {
				Coin.findByAmount(coinAmount).add();
				holdingAmount = holdingAmount - coinAmount;
			}
		} while (holdingAmount > 0);
	}
}
