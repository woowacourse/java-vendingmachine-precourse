package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

/**
 * 자판기의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Machine {
	private Display display;

	public Machine() {
		this.display = new Display();
	}

	public void run() {
		prepareCoins();
	}

	private void prepareCoins() {
		display.askHoldingAmount();
		Console.readLine();
	}
}
