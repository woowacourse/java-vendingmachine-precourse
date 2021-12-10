package vendingmachine.dto;

import java.util.List;
import java.util.stream.Collectors;

public class InputItemDTO {
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final List<String> itemProperties;

    public InputItemDTO(final List<String> itemProperties) {
        this.itemProperties = itemProperties.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int getNumberOfProperties() {
        return itemProperties.size();
    }

    public String getName() {
        return this.itemProperties.get(NAME_INDEX);
    }

    public String getPrice() {
        return this.itemProperties.get(PRICE_INDEX);
    }

    public String getQuantity() {
        return this.itemProperties.get(QUANTITY_INDEX);
    }
}
