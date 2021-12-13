package vendingmachine.repository;

import vendingmachine.domain.ChangeSafe;

public class ChangeSafeRepository {

	private static ChangeSafe changeSafe = new ChangeSafe();

	public ChangeSafeRepository() {
	}

	public ChangeSafeRepository(ChangeSafe otherChangeSafe) {
		changeSafe = otherChangeSafe;
	}

	public String save(ChangeSafe newChangeSafe) {
		changeSafe = changeSafe.merge(newChangeSafe);
		return changeSafe.toString();
	}
}
