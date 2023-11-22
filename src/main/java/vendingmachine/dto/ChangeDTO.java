package vendingmachine.dto;

import java.util.Map;
import vendingmachine.constants.Coin;

public record ChangeDTO(Map<Coin, Integer> changeStatus) {
}
