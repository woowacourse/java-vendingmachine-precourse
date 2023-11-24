package vendingmachine.dto;

import java.util.Map;
import vendingmachine.constants.Coin;

public class ChangeDTO {
    private final Map<Coin, Integer> changeStatus;

    public ChangeDTO(Map<Coin, Integer> changeStatus) {
        this.changeStatus = changeStatus;
    }

    public Map<Coin, Integer> getChangeStatus() {
        return changeStatus;
    }
}
