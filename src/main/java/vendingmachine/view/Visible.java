package vendingmachine.view;

public enum Visible {
	HIDE, SHOW;
	public boolean isShow() {
		return this == Visible.SHOW;
	}
}
