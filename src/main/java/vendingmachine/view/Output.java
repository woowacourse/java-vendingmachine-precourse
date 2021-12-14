package vendingmachine.view;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import vendingmachine.coin.Coin;
import vendingmachine.machine.Machine;

public class Output {
	public void printCoins(Machine machine){
		Map<Coin, Integer> coins = machine.getCoins();
		for (Coin coin : Coin.sortedCoins()){
			System.out.println(coin.getAmount()+"원 - "+coins.get(coin)+"개");
		}

	}
}
