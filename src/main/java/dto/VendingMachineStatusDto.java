package dto;

public class VendingMachineStatusDto {
    private final int coin;
    private final int count;

    private VendingMachineStatusDto(final int coin, final int count){
        this.coin = coin;
        this.count = count;
    }

    public static VendingMachineStatusDto create(final int coin, final int count) {
        return new VendingMachineStatusDto(coin, count);
    }
}
