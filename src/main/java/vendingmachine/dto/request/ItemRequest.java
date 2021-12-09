package vendingmachine.dto.request;

import vendingmachine.dto.ItemInfo;

public class ItemRequest {
    private final String nameInput;
    private final String priceInput;

    public ItemRequest(String nameInput, String priceInput) {
        this.nameInput = nameInput;
        this.priceInput = priceInput;
    }

    public ItemInfo toItemInfo() {
        return new ItemInfo(toItemName(nameInput), toItemPrice(priceInput));
    }

    private String toItemName(String nameInput) {
        validateName(nameInput);
        return nameInput;
    }

    private int toItemPrice(String priceInput) {
        int price;
        try {
            price = Integer.parseInt(priceInput);
            validatePrice(price);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("상품 가격은 100원 이상의 정수이며 10원 단위로 나눠 떨어져야 합니다");
        }
        return price;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("상품 명은 최소 한 글자 이상이어야 합니다");
        }
    }

    private void validatePrice(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
