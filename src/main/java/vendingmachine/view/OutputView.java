package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;

import java.sql.SQLOutput;
import java.util.List;

import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.Coin;

public class OutputView {

	public static void printMachineCoins() {
		List<Coin> coins = Coin.get();
		out.println(OUTPUT_MACHINE_MONEY);
		coins.forEach(Coin::selfDescription);
		SystemMessage.printEmptyLine();
	}
}
