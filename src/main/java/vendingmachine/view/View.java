package vendingmachine.view;

public abstract class View {
	private Visible visible;

	public View() {
		this.visible = Visible.SHOW;
	}

	public void hide() {
		this.visible = Visible.HIDE;
	}

	public boolean isShow() {
		return visible.isShow();
	}
}
