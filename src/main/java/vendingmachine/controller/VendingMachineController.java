package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.service.CoinService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private InputView inputView;
	private CoinService coinService;
	private List<Coin> coins;

	public VendingMachineController() {
		inputView = new InputView();
		coinService = new CoinService();
	}

	public void machineInit(){
		int savedMoney = inputView.getSavedMoney();
		coins = Coin.init();
		HashMap<Coin, Integer> savedCoins = coinService.getRandomCoins(coins, savedMoney);
	}
}
