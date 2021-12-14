package vendingmachine.controller.classes;

import static vendingmachine.constant.PromptConstant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.controller.LeftChangeCalculatorInterface;
import vendingmachine.model.Coin;

public class LeftChangeCalculator implements LeftChangeCalculatorInterface {
	private List<Integer> orderList = new ArrayList<>();
	private HashMap<Integer, Integer> resultHashMap = new HashMap<>();
	@Override
	public String calculate(int change, HashMap<Integer, Integer> coinMap) {
		initOrderList();
		String calculateString = "";
		for (Integer order: orderList) {
			while (coinMap.get(order) > 0) {
				if (change >= coinMap.get(order) * order) {
					change -= coinMap.get(order) * order;
					resultHashMap.put(order, coinMap.get(order));
					break;
				}
				int tmp = coinMap.get(order) - 1;
				coinMap.put(order, tmp);
			}
		}

		for (Map.Entry<Integer, Integer> entry : resultHashMap.entrySet()) {
			calculateString += entry.getKey() + WON_STRING;
			calculateString += " - ";
			calculateString += entry.getValue() + COUNT_STRING + "\n";
		}
		return calculateString;
	}

	private void initOrderList() {
		orderList.add(Coin.COIN_500.getAmount());
		orderList.add(Coin.COIN_100.getAmount());
		orderList.add(Coin.COIN_50.getAmount());
		orderList.add(Coin.COIN_10.getAmount());
	}
}
