package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.controller.MachineControllerImpl;
import vendingmachine.service.MachineService;
import vendingmachine.service.MachineServiceImpl;
import vendingmachine.view.input.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.reader.ConsoleReader;
import vendingmachine.view.reader.Reader;

public class AppConfig {

	private static final AppConfig instance = new AppConfig();

	public final Reader reader;
	public final OutputView outputView;
	public final InputView inputView;
	public final MachineService machineService;
	public final MachineController machineController;

	public AppConfig() {
		this.reader = new ConsoleReader();
		this.outputView = new OutputView();
		this.inputView = new InputView(reader, outputView);
		this.machineService = new MachineServiceImpl();
		this.machineController = new MachineControllerImpl(machineService, inputView, outputView);
	}

	public static AppConfig getInstance() {
		return instance;
	}

}
