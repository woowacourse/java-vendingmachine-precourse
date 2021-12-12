package vendingmachine.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;

class InputClientTest extends ConsoleTest {

	@Test
	public void testInput() {
	    // given
		String prompt = "input value : ";
		String response = "some value";
		InputClient inputClient = new ConsoleInputClient(new ConsoleOutputClient());
		// when
		changeInput(response);
		String input = inputClient.input(prompt);
		// then
		assertEquals("some value", input);
	}

}