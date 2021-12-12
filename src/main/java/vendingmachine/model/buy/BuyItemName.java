package vendingmachine.model.buy;

import java.util.Objects;

import vendingmachine.model.Item.Items;

public class BuyItemName {
    public static final String NOT_EXISTED_ITEM_EXCEPTION = "[ERROR] 존재하지 않는 제품입니다.";
    String name;

    public BuyItemName(String name) {
        validBuyItemName(name);
        this.name = name;
    }

    private void validBuyItemName(String name) {
        if (!Items.containsName(name)) {
            throw new IllegalArgumentException(NOT_EXISTED_ITEM_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BuyItemName that = (BuyItemName)o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
