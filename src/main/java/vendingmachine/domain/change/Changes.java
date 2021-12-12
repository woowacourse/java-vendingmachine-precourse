package vendingmachine.domain.change;

import java.util.Collections;
import java.util.List;

public class Changes {
    private final List<Change> changes;

    public Changes(List<Change> changes) {
        this.changes = changes;
    }

    public List<Change> getChanges() {
        return Collections.unmodifiableList(changes);
    }
}