package vendingmachine.domain;

import static vendingmachine.Error.*;

public class ChangesExceptionTest extends BasicTest {
	public String moneyOfChanges;
	public String errorMessage;

	private ChangesExceptionTest(String moneyOfChanges, String errorMessage) {
		this.moneyOfChanges = moneyOfChanges;
		this.errorMessage = errorMessage;
	}

	public static ChangesExceptionTest[] getChangesExceptionTestData() {
		ChangesExceptionTest[] changesExceptionTestData = new ChangesExceptionTest[MAX_TESTCASE];

		ChangesExceptionTest nowTestData = new ChangesExceptionTest(
			"test", MONEY_OF_CHANGES_ONLY_NUMBER
		);
		changesExceptionTestData[0] = nowTestData;

		ChangesExceptionTest nowTestData2 = new ChangesExceptionTest(
			"-1", MONEY_OF_CHANGES_OVER_ZERO
		);
		changesExceptionTestData[1] = nowTestData2;

		ChangesExceptionTest nowTestData3 = new ChangesExceptionTest(
			"123", MONEY_OF_CHANGES_DIVIDED_BY_TEN
		);
		changesExceptionTestData[2] = nowTestData3;

		return changesExceptionTestData;
	}
}
