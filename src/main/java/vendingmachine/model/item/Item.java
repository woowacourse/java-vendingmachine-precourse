package vendingmachine.model.item;

import java.util.Objects;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;
import vendingmachine.model.vo.Money;

public class Item {
    private static final String ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE = "상품 정보에 누락이 있습니다.";
    private static final String WANTED_ITEM_SOLD_OUT_EXCEPTION_MESSAGE = "구입하려는 상품은 품절입니다.";
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

    public boolean hasName(final String userWantedItemName) {
        return this.name.equals(userWantedItemName);
    }

    public void sell(final Money remainingInputMoney) {
        checkRemainingQuantity();
        remainingQuantity.decrease();
        price.payWith(remainingInputMoney);
    }

    private void checkRemainingQuantity() {
        if (remainingQuantity.isZero()) {
            throw new IllegalArgumentException(WANTED_ITEM_SOLD_OUT_EXCEPTION_MESSAGE);
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
