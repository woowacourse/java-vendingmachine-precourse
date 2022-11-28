package dto;

public class MoneyRequestDto {
    private final int money;

    public MoneyRequestDto(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
