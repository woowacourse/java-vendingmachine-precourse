package service;

import domain.PossessionAmount;

public class PossessionAmountService {
    public PossessionAmount createPossessionAmount(final String possessionAmount){
        return PossessionAmount.create(possessionAmount);
    }
}
