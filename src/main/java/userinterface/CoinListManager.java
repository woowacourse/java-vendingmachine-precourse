package userinterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import utils.InputManager;
import utils.validator.IsAmount;
import vendingmachine.Coin;
import vendingmachine.Coins;

public class CoinListManager {
	private int sumOfChange = 0;
	private final Coins coinList;
	Coin[] coinArrays = {Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10};

	public CoinListManager(Coins coinList) {
		this.coinList = coinList;
		initDeposit();
	}

	private void initDeposit() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

		IsAmount validator = new IsAmount();
		InputManager inputManager = new InputManager();
		String input = inputManager.getStringWithInput(validator);
		sumOfChange = Integer.parseInt(input);
		System.out.println();
	}

	public void makeRandomList() {
		List<Integer> valueList = Arrays.asList(500, 100, 50, 10);
		while (0 < sumOfChange) {
			int randomAmount = Randoms.pickNumberInList(valueList);
			if (!isAvailableToDeduct(randomAmount)) {
				continue;
			}

			sumOfChange -= randomAmount;
			coinList.addOne(randomAmount);
		}
	}

	private boolean isAvailableToDeduct(int amount) {
		return amount <= sumOfChange;
	}

	public void printCoinList() {
		System.out.println();
		System.out.println("자판기가 보유한 동전");

		Stream.of(coinArrays).forEach(coin -> printCoinCount(coin, coinList.get(coin)));
	}

	private void printCoinCount(Coin coin, int count) {
		System.out.printf("%s원 - %d개\n", coin.toString(), count);
	}

	public void returnChange(int change) {
		new ChangeReturner(change).run();
	}

	class ChangeReturner {
		int sumOfChange;

		ChangeReturner(int money) {
			sumOfChange = money;
		}

		public void run() {
			Stream.of(coinArrays).forEach(coin -> {
				int countOfCoin = returnChange(coin);
				if (countOfCoin != 0) {
					printCoinCount(coin, countOfCoin);
				}
			});
		}

		private int returnChange(Coin coin) {
			int coinValue = coin.getAmount();
			int numOfCoin = 0;

			while (!coinList.isEmpty(coin) && coinValue <= sumOfChange) {
				sumOfChange -= coinValue;
				coinList.deduct(coin);
				numOfCoin++;
			}

			return numOfCoin;
		}
	}
}
