package domain;

import domain.wrapper.VendingMachineAmount;

public class PossesionAmount {

    private final VendingMachineAmount vendingMachineAmount;
    private PossesionAmount(final String possessionAmount){
        this.vendingMachineAmount = VendingMachineAmount.create(possessionAmount);
    }

    public static PossesionAmount create(final String possessionAmount){
        return new PossesionAmount(possessionAmount);
    }

    //쉽게 말해, getter를 통해 얻은 상태값으로 하려고 했던 '행동'을
    // 그 상태값을 가진 객체가 하도록 '행동'의 주체를 옮기는 것이다.

    public int getPossessionAmount(){
        return vendingMachineAmount.getVendingMachineAmount();
    }
}
