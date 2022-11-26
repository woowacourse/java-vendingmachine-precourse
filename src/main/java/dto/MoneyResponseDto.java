package dto;

public class MoneyResponseDto {
    private final int money;

    public MoneyResponseDto(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
