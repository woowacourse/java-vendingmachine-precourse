package vendingmachine.config;

import vendingmachine.client.ConsoleErrorClient;
import vendingmachine.client.ConsoleInputClient;
import vendingmachine.client.ConsoleOutputClient;
import vendingmachine.client.ErrorClient;
import vendingmachine.client.InputClient;
import vendingmachine.client.OutputClient;

public class ClientConfig {
	public static InputClient getInputClient() {
		return new ConsoleInputClient(getOutputClient());
	}

	public static OutputClient getOutputClient() {
		return new ConsoleOutputClient();
	}

	public static ErrorClient getErrorClient() {
		return new ConsoleErrorClient();
	}

}
