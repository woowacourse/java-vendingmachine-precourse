package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.processor.InputProcessor;
import vendingmachine.processor.OutputProcessor;

public abstract class VendingMachineView {
	protected final InputProcessor inputProcessor = new InputProcessor();
	protected final OutputProcessor outputProcessor = new OutputProcessor();
	protected final VendingMachineController controller;
	private ViewState viewState;

	public VendingMachineView(VendingMachineController controller) {
		this.viewState = ViewState.SHOW;
		this.controller = controller;
	}

	public void hide() {
		this.viewState = ViewState.HIDE;
	}

	public boolean isShow() {
		return viewState.isShow();
	}

	public abstract void show();
}
