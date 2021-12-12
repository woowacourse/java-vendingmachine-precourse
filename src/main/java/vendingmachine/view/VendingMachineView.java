package vendingmachine.view;

import vendingmachine.VendingMachineController;
import vendingmachine.processor.InputProcessor;
import vendingmachine.processor.OutputProcessor;

public abstract class VendingMachineView {
	protected final InputProcessor inputProcessor = new InputProcessor();
	protected final OutputProcessor outputProcessor = new OutputProcessor();
	protected final VendingMachineController controller;
	private Visible visible;

	public VendingMachineView(VendingMachineController controller) {
		this.visible = Visible.SHOW;
		this.controller = controller;
	}

	public void hide() {
		this.visible = Visible.HIDE;
	}

	public boolean isShow() {
		return visible.isShow();
	}

	public abstract void show();
}
