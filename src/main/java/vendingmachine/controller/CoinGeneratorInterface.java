package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.model.Coin;

public interface CoinGeneratorInterface {
	HashMap<Coin, Integer> getRandomCoins(int price);
}
