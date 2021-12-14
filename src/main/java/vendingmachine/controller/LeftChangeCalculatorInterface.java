package vendingmachine.controller;

import java.util.HashMap;

public interface LeftChangeCalculatorInterface {
	String calculate(int change, HashMap<Integer, Integer> coinMap);
}
