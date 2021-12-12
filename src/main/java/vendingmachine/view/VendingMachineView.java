package vendingmachine.view;

import vendingmachine.VendingMachineController;
import vendingmachine.processor.InputProcessor;
import vendingmachine.processor.OutputProcessor;

public abstract class VendingMachineView {
	private Visible visible;
	protected final InputProcessor inputProcessor;
	protected final OutputProcessor outputProcessor;
	protected final VendingMachineController controller;

	public VendingMachineView() {
		this.visible = Visible.SHOW;
		inputProcessor = new InputProcessor();
		outputProcessor = new OutputProcessor();
		controller = new VendingMachineController();
	}

	public void hide() {
		this.visible = Visible.HIDE;
	}

	public boolean isShow() {
		return visible.isShow();
	}
}
