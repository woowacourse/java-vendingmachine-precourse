package vendingmachine.view.classes;

import static vendingmachine.constant.PromptConstant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vendingmachine.model.Coin;

public class PrintHandler {
	private List<Coin> coinList = new ArrayList<>();
	public void printCoinStatus(HashMap<Integer, Integer> coinMap) {
		initCoinList();
		String statusScript = makeStatusScriptByMap(coinMap);
		System.out.println(statusScript);
	}

	private String makeStatusScriptByMap(HashMap<Integer, Integer> coinMap) {
		String statusScript = "";
		for (Coin coin: coinList) {
			statusScript = getOneLineOfStatusScript(coinMap, statusScript, coin);
		}
		return statusScript;
	}

	private String getOneLineOfStatusScript(HashMap<Integer, Integer> coinMap, String statusScript, Coin coin) {
		statusScript += coin.getAmount() + WON_STRING + " - " + coinMap.get(coin.getAmount()) + COUNT_STRING + "\n";
		return statusScript;
	}

	private void initCoinList() {
		coinList.add(Coin.COIN_500);
		coinList.add(Coin.COIN_100);
		coinList.add(Coin.COIN_50);
		coinList.add(Coin.COIN_10);
	}
}
