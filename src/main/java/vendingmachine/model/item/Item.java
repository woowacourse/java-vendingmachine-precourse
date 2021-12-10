package vendingmachine.model.item;

import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE;

import java.util.Objects;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;

public class Item {
    private static final int NUMBER_OF_ITEM_PROPERTIES = 3;
    private final String name;
    private final Price price;
    private final Quantity remainingQuantity;

    public Item(InputItemDTO itemInfo) {
        validateNumberOfInfo(itemInfo.getNumberOfProperties());
        name = itemInfo.getName();
        price = new Price(itemInfo.getPrice());
        remainingQuantity = new Quantity(itemInfo.getQuantity());
    }

    private void validateNumberOfInfo(final int actualNumberOfItemProperties) {
        if (actualNumberOfItemProperties != NUMBER_OF_ITEM_PROPERTIES) {
            throw new IllegalArgumentException(ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
