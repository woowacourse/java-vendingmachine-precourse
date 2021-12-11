package vendingmachine.model;

import java.util.List;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.item.Items;
import vendingmachine.model.vo.Money;

public class VendingMachine {
    private final Money remainingInputMoney;
    private final Items items;

    public VendingMachine(final String inputMoney, final List<InputItemDTO> itemInfos) {
        remainingInputMoney = new Money(inputMoney);
        items = new Items(itemInfos);
    }

    public void sell(final String userWantedItemName) {
        items.sell(userWantedItemName, remainingInputMoney);
    }

    public int getRemainingInputMoney() {
        return remainingInputMoney.getValue();
    }
}
