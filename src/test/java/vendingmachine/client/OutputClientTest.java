package vendingmachine.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;

class OutputClientTest extends ConsoleTest {

	@Test
	public void testOutput() {
	    // given
		OutputClient client = new ConsoleOutputClient();
	    // when
		client.output("hello world");
	    // then
		assertEquals("hello world\n", outputStream.toString());
	}
}