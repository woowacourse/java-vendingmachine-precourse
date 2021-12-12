package vendingmachine.service;

import vendingmachine.model.Changes;

public class ChangesService {

    public Changes createChanges(int amount) {
        Changes changes = new Changes();
        changes.calculateChanges(amount);
        return changes;
    }
}
