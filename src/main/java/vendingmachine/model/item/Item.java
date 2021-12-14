package vendingmachine.model.item;

import java.util.Objects;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.item.vo.Price;
import vendingmachine.model.item.vo.Quantity;
import vendingmachine.model.vo.Money;

public class Item {
    private static final String ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE = "상품 정보에 누락이 있습니다.";
    private static final String WANTED_ITEM_SOLD_OUT_EXCEPTION_MESSAGE = "구입하려는 상품은 품절입니다.";
    private static final String PRICE_MORE_EXPENSIVE_EXCEPTION_MESSAGE = "남은 투입 금액으로 해당 상품을 구매할 수 없습니다.";
    private static final int NUMBER_OF_ITEM_PROPERTIES = 3;

    private final String name;
    private final Price price;
    private final Quantity remainingQuantity;

    public Item(final InputItemDTO itemInfo) {
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
        if (isSoldOut()) {
            throw new IllegalArgumentException(WANTED_ITEM_SOLD_OUT_EXCEPTION_MESSAGE);
        }
        if (isPriceMoreExpensiveThanRemainingInputMoney(remainingInputMoney)) {
            throw new IllegalArgumentException(PRICE_MORE_EXPENSIVE_EXCEPTION_MESSAGE);
        }
        remainingQuantity.decrease();
        price.payWith(remainingInputMoney);
    }

    private boolean isSoldOut() {
        return remainingQuantity.isZero();
    }

    private boolean isPriceMoreExpensiveThanRemainingInputMoney(final Money remainingInputMoney) {
        return price.isMoreExpensiveThan(remainingInputMoney);
    }

    public boolean cannotSell(final Money remainingInputMoney) {
        return isSoldOut() || isPriceMoreExpensiveThanRemainingInputMoney(remainingInputMoney);
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
