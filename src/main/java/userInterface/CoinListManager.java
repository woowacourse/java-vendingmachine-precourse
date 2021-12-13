package userInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import utils.validator.isAmount;
import utils.InputManager;
import vendingmachine.Coin;
import vendingmachine.Coins;

public class CoinListManager {
	private int sumOfChange = 0;
	private Coins coinList;
	Coin[] coinArrays = {Coin.COIN_500,Coin.COIN_100,Coin.COIN_50, Coin.COIN_10};

	public CoinListManager(Coins coinList) {
		this.coinList = coinList;
		initDeposit();
	}

	private void initDeposit() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

		isAmount validator = new isAmount();
		InputManager inputManager = new InputManager();
		String input = inputManager.getStringWithInput(validator);
		sumOfChange = Integer.parseInt(input);
		System.out.println();
	}

	public void makeRandomList() {
		// 1. 랜덤을 뽑는 리스트는 [500,100,50,10]이다.
		// 2. sumOfChange 가 0이 될때까지 반복한다.
		// 3. 만약 sumOfChange 가 뽑힌 값보다 작으면, 리스트에서 해당 값을 제외하고 continue 한다.
		// 4. 리스트에서 뽑은 값 만큼 sumOfChange 에서 값을 빼고, coinList 에는 addOne() 한다.
		List<Integer> valueList = Arrays.asList(500,100,50,10);
		while ( sumOfChange < 0 ) {
			int randomAmount = Randoms.pickNumberInList(valueList);
			if (!isAvailableToDeduct(randomAmount)) {
				valueList.remove(new Integer(randomAmount));
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

		Stream.of(coinArrays).forEach(coin -> {printCoinCount(coin, coinList.get(coin));
		});
	}

	private void printCoinCount(Coin coin, int count) {
		System.out.printf("%s원 - %d개\n",coin.toString(),count);
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
				numOfCoin ++;
			}
			return numOfCoin;
		}

	}
}
