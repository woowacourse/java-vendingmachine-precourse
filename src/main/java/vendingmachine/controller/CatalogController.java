package vendingmachine.controller;

import vendingmachine.service.CatalogService;
import vendingmachine.view.CatalogInputView;

public class CatalogController {

	public static void setCatalogListInput() {
		CatalogInputView.printInputGuide();
		CatalogService.setCatalogListByInput();
	}
}
