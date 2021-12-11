package vendingmachine.model.receiver;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class ProductInfoReceiver {

	public ArrayList<String[]> receive() {
		ArrayList<String[]> splitInfoArrList = new ArrayList<>();

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			splitInfoArrList.clear();
			String input = Console.readLine();
			rewindSwitch = makeSplitInfoArrList(splitInfoArrList, input);
		}

		return splitInfoArrList;
	}

	private boolean makeSplitInfoArrList(ArrayList<String[]> splitInfoArrList, String input) {
		String[] infoArr = input.replace("[", "").replace("]", "").split(";");
		for (String info : infoArr) {
			String[] splitInfoArr = info.split(",");

			// if (new ProductInfoValidator().validate(splitInfoArrList, splitInfoArr)) {
			// 	return true;
			// }

			splitInfoArrList.add(splitInfoArr);
		}

		return false;
	}
}
