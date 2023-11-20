package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.VendingMachineDto;
import vendingmachine.service.InputProcessingService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    void run() {
        InputProcessingService inputProcessingService = new InputProcessingService();
        VendingMachineDto vendingMachineDto = inputProcessingService.createVendingMachine(InputView::getUserInput,
                OutputView::printVendingMachineCoinsInputRequest, OutputView::printErrorMessage).toDto();
        OutputView.printVendingMachineCoins(vendingMachineDto);
    }
}
