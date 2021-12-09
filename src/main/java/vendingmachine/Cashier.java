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
		int coinAmount = Randoms.pickNumberInList(getCoinAmountList());
		// TODO: 해당 금액이 보유금액보다 작거나 같으면 해당 동전을 한 개 생성한다
	}

	private ArrayList<Integer> getCoinAmountList() {
		ArrayList<Integer> coinAmountList = new ArrayList<>();
		coinAmountList.add(10);
		coinAmountList.add(50);
		coinAmountList.add(100);
		coinAmountList.add(500);
		return coinAmountList;
	}
}
