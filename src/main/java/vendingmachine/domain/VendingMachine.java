package vendingmachine.domain;

public class VendingMachine {

	private Changes changes;

	public Changes getChanges() {
		return changes;
	}

	public void createChanges(int inputMoney) {
		changes = new Changes(inputMoney);
		changes.createRandomCoin();
		changes.getCoinMap().forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});

	}

}
