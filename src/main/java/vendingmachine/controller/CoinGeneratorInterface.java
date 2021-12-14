package vendingmachine.controller;

import java.util.HashMap;

public interface CoinGeneratorInterface {
	HashMap<Integer, Integer> getRandomCoins(int price);
}
