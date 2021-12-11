package vendingmachine.model.receiver;

import camp.nextstep.edu.missionutils.Console;

public class NameForBuyReceiver {

	public String receive() {
		String name = "init";

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			name = Console.readLine();

			// rewindSwitch = new NameForBuyValidator().validate(name);
		}

		return name;
	}
}
