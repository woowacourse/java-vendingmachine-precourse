package userInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import utils.validator.isAmount;
import utils.InputManager;
import vendingmachine.Coin;
import vendingmachine.Coins;

public class CoinListManager {
	private int deposit = 0;
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
		deposit = Integer.parseInt(input);
	}

	public void makeRandomList() {
		Coin[] coinArraysWithOutTen = {Coin.COIN_500,Coin.COIN_100,Coin.COIN_50};

		for (Coin coin : coinArraysWithOutTen) {
			int value = coin.getAmount();
			int randomNum = rand(deposit/value);
			coinList.put(coin,randomNum);
			deposit -= randomNum*value;
		}

		Coin coinOfMinValue = Coin.COIN_10;
		coinList.put(coinOfMinValue,deposit/coinOfMinValue.getAmount());
		deposit = 0;
	}

	private int rand(int maxCount) {
		List<Integer> numList = new ArrayList<>();
		IntStream.range(0,maxCount+1).forEach(i -> numList.add(i));

		return Randoms.pickNumberInList(numList);
	}

	public void printCoinList() {
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
