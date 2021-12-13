package vendingmachine.repository;

import vendingmachine.domain.ChangeSafe;

public class ChangeSafeRepository {

	private static ChangeSafe changeSafe = new ChangeSafe();

	public ChangeSafeRepository() {
	}

	public ChangeSafeRepository(ChangeSafe otherChangeSafe) {
		changeSafe = otherChangeSafe;
	}

	public ChangeSafe save(ChangeSafe newChangeSafe) {
		changeSafe = newChangeSafe;
		return get();
	}

	public ChangeSafe get() {
		return changeSafe;
	}
}
