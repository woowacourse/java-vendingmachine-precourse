package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class CoinStoreTest {

	@Test
	void test() {
		CoinStore coinStore = new CoinStore(450);
		System.out.println(coinStore);
	}

}