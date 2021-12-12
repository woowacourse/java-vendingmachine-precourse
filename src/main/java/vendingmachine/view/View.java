package vendingmachine.view;

import vendingmachine.processor.InputProcessor;
import vendingmachine.processor.OutputProcessor;

public abstract class View {
	private Visible visible;
	protected final InputProcessor inputProcessor;
	protected final OutputProcessor outputProcessor;

	public View() {
		this.visible = Visible.SHOW;
		inputProcessor = new InputProcessor();
		outputProcessor = new OutputProcessor();
	}

	public void hide() {
		this.visible = Visible.HIDE;
	}

	public boolean isShow() {
		return visible.isShow();
	}
}
