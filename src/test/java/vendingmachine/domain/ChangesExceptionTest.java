package vendingmachine.domain;

import java.util.ArrayList;

import static vendingmachine.Error.*;

public class ChangesExceptionTest extends BasicTest {
	public String moneyOfChanges;

	private ChangesExceptionTest(String moneyOfChanges, String errorMessage) {
		this.moneyOfChanges = moneyOfChanges;
		this.errorMessage = errorMessage;
	}

	public static ArrayList<ChangesExceptionTest> getChangesExceptionTestData() {
		ArrayList<ChangesExceptionTest> changesExceptionTestData = new ArrayList<>(MAX_TESTCASE);

		changesExceptionTestData.add(new ChangesExceptionTest("test", MONEY_OF_CHANGES_ONLY_NUMBER));
		changesExceptionTestData.add(new ChangesExceptionTest("1500원", MONEY_OF_CHANGES_ONLY_NUMBER));
		changesExceptionTestData.add(new ChangesExceptionTest("-1", MONEY_OF_CHANGES_OVER_ZERO));
		changesExceptionTestData.add(new ChangesExceptionTest("123", MONEY_OF_CHANGES_DIVIDED_BY_TEN));

		return changesExceptionTestData;
	}
}
