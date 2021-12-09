package vendingmachine.Controller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        final VendingMachineService vendingMachineService = new VendingMachineService(inputView, outputView);
        VendingMachine vendingMachine = createVendingMachine(vendingMachineService);

    }

    private VendingMachine createVendingMachine(final VendingMachineService vendingMachineService) {
        try {
            String inputMachineHaveMoney = vendingMachineService.inputMachineHaveMoney();

            return new VendingMachine(inputMachineHaveMoney);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return createVendingMachine(vendingMachineService);
        }
    }

}
