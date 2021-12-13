package userInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import utils.validator.isAmount;
import utils.InputManager;
import vendingmachine.Coin;
import vendingmachine.Coins;

public class CoinListMaker {
	private int deposit = 0;
	private Coins coinList;

	CoinListMaker(Coins coinList) {
		this.coinList = coinList;
		initDeposit();
	}

	private void initDeposit() {
		isAmount validator = new isAmount();
		InputManager inputManager = new InputManager();
		String input = inputManager.getStringWithInput(validator);
		deposit = Integer.parseInt(input);
	}

	public void makeRandomList() {
		Coin[] coinArrays = {Coin.COIN_500,Coin.COIN_100,Coin.COIN_50};

		for (Coin coin : coinArrays) {
			int value = coin.getAmount();
			int randomNum = rand(deposit/value);
			coinList.put(coin,randomNum);
			deposit -= randomNum*value;
		}

		coinList.put(Coin.COIN_10,deposit/10);
		deposit = 0;
	}

	private int rand(int maxCount) {
		List<Integer> numList = new ArrayList<>();
		IntStream.range(0,maxCount+1).forEach(i -> numList.add(i));

		return Randoms.pickNumberInList(numList);
	}
}
