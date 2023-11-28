package domain.wrapper;

import java.util.Objects;

import static util.message.ExceptionMessage.BLANK_MESSAGE;

public class Name {
    private final String name;

    private Name(final String name){
        validateBlank(name);
        this.name = name;
    }

    public static Name create(final String name){
        return new Name(name);
    }

    private void validateBlank(final String productDetail){
        if (productDetail == null || productDetail.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "상품명"));
        }
    }

    @Override
    public boolean equals(Object diffName) {
        if (this == diffName) return true;
        if (diffName == null || getClass() != diffName.getClass()) return false;
        Name nameInfo = (Name) diffName;
        return Objects.equals(name, nameInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
