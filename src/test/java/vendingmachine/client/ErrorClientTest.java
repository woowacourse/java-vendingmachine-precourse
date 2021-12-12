package vendingmachine.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;

class ErrorClientTest extends ConsoleTest {

	@Test
	public void testError() {
		// given
		ErrorClient errorClient = new ConsoleErrorClient();
		String error = "Some Exception Occured";
		// when
		errorClient.error(error);
		// then
		assertEquals("Some Exception Occured\n", outputStream.toString());
	}
}