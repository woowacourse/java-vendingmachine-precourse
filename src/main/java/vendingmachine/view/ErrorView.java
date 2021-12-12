package vendingmachine.view;

import vendingmachine.client.ErrorClient;

public class ErrorView {
	private static final String PREFIX = "[ERROR] ";

	private final ErrorClient client;

	public ErrorView(ErrorClient client) {
		this.client = client;
	}

	public void error(String msg) {
		client.error(PREFIX + msg);
	}
}
