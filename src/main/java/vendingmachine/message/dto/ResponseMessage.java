package vendingmachine.message.dto;

import java.util.Map;

import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;

public class ResponseMessage {

	private StringBuilder result;

	public void init() {
		result = new StringBuilder();
	}

	public static void of(String message) {
		System.out.println(message);
	}

	public static void printInputCost(int inputCost) {
		System.out.println(('\n' + Message.PRINT_INPUT_COSTS.getMessage() + inputCost + Message.PRINT_MONEY_UNIT.getMessage()));
	}

	public void addMessage(String message) {
		result.append(message);
	}

	public void addCoinCountMessage(Map<Integer, Integer> map) {
		map.keySet().forEach(key -> {
			addMessage(key + Message.PRINT_MONEY_UNIT.getMessage() + " - " + map.get(key) + Message.PRINT_AMOUNT_UNIT.getMessage() + '\n');
		});
	}

	public String getResult() {
		return result.toString();
	}
}
