package service;

import domain.PossesionAmount;

public class PossessionAmountService {
    public PossesionAmount createPossessionAmount(final String possessionAmount){
        return PossesionAmount.create(possessionAmount);
    }
}
