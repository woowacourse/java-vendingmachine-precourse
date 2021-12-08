package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.repository.VendingMachine;

public class VendingMachineService {
	private static final int ZERO = 0;
	private static final List<Integer> coin_kind = Arrays.asList(Coin.COIN_10.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_500.getAmount());

	private final VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void changeMoneyToCoin(int money) {
		while (money > ZERO) {
			int coin = Randoms.pickNumberInList(coin_kind);
			if (canChange(money, coin)) {
				vendingMachine.addCoin(Coin.fromMoney(coin));
				money -= coin;
			}
		}
	}

	private boolean canChange(int money, int coin) {
		if (money - coin >= ZERO) {
			return true;
		}
		return false;
	}
}
