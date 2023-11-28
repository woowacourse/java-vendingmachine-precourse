package domain;

import domain.wrapper.VendingMachineAmount;

public class PossessionAmount {

    private final VendingMachineAmount vendingMachineAmount;
    private PossessionAmount(final String possessionAmount){
        this.vendingMachineAmount = VendingMachineAmount.create(possessionAmount);
    }

    public static PossessionAmount create(final String possessionAmount){
        return new PossessionAmount(possessionAmount);
    }

    public int getPossessionAmount(){
        return vendingMachineAmount.getVendingMachineAmount();
    }
}
