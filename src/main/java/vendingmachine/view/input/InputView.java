package vendingmachine.view.input;

import vendingmachine.dto.InputItemDTO;

import java.util.List;

public interface InputView {
    String inputVendingMachineMoney();

    String inputCustomerMoney();

    String inputWantedItemName();

    void showErrorMessage(final String errorMessage);

    List<InputItemDTO> inputItemInfos();
}
