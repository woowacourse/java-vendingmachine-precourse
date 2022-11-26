package dto;

public class HoldingSumRequestDto {
    private final int holdingSum;

    public HoldingSumRequestDto(int holdingSum) {
        this.holdingSum = holdingSum;
    }

    public int getHoldingSum() {
        return holdingSum;
    }
}
