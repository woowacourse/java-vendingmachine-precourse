package vendingmachine.message.dto;

import java.util.Map;

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
		System.out.println(
			Message.LINE_BREAKER.getMessage() + Message.PRINT_INPUT_COSTS.getMessage() + inputCost + Message.PRINT_MONEY_UNIT.getMessage());
	}

	public void addMessage(String message) {
		result.append(message);
	}

	public void addCoinCountMessage(Map<Integer, Integer> map) {
		map.keySet().forEach(key -> {
			addMessage(key + Message.PRINT_MONEY_UNIT.getMessage() + Message.REST_MONEY_SEPARATOR.getMessage() + map.get(key)
				+ Message.PRINT_AMOUNT_UNIT.getMessage() + Message.LINE_BREAKER.getMessage());
		});
	}

	public String getResult() {
		return result.toString();
	}
}
