package vendingmachine.service;

import vendingmachine.model.Change;
import vendingmachine.model.Changes;
import vendingmachine.util.constant.Symbol;

import java.util.List;
import java.util.stream.Collectors;

public class ChangesService {

    public Changes createChanges(int amount) {
        Changes changes = new Changes();
        changes.calculateChanges(amount);
        return changes;
    }

    public String getHoldingChanges(Changes changes) {
        return changes.toString();
    }

    public String getReturnChanges(int amount, Changes changes) {
        int totalAmount = changes.getSumOfChanges();

        if (totalAmount <= amount) {
            return getAllChanges(changes.getChanges());
        }
        return getAllChanges(changes.calculateReturnChanges(amount));
    }

    private String getAllChanges(List<Change> changes) {
        return changes.stream()
                .filter(change -> change.getNumber() > 0)
                .map(Change::toString)
                .collect(Collectors.joining(Symbol.NEW_LINE));
    }
}
