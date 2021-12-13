package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.model.Coin;

public interface CoinGeneratorInterface {
	HashMap<Integer, Integer> getRandomCoins(int price);
}
