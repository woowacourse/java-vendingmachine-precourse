package vendingmachine.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vendingmachine.constant.Message;

public class DuplicationChecker {

	public void isDuplication(List<String> inputList) {
		Set<String> duplicationCheck = new HashSet<>();

		for (String input : inputList) {

			if (duplicationCheck.contains(input)) {
				throw new IllegalArgumentException(Message.ERROR_DUPLICATION);
			}

			duplicationCheck.add(input);
		}

	}
}
