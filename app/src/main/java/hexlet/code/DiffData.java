package hexlet.code;

import java.util.Map;
import java.util.Set;

public final class DiffData {

    private final Set<String> added;
    private final Set<String> deleted;
    private final Set<String> unchanged;
    private final Set<String> changed;

    private final Map<String, Object> firstMap;
    private final Map<String, Object> secondMap;

    public DiffData(
            Set<String> added,
            Set<String> deleted,
            Set<String> unchanged,
            Set<String> changed,
            Map<String, Object> firstMap,
            Map<String, Object> secondMap
    ) {
        this.added = added;
        this.deleted = deleted;
        this.unchanged = unchanged;
        this.changed = changed;
        this.firstMap = firstMap;
        this.secondMap = secondMap;
    }

    public Set<String> getAdded() {
        return added;
    }

    public Set<String> getDeleted() {
        return deleted;
    }

    public Set<String> getUnchanged() {
        return unchanged;
    }

    public Set<String> getChanged() {
        return changed;
    }

    public Map<String, Object> getFirstMap() {
        return firstMap;
    }

    public Map<String, Object> getSecondMap() {
        return secondMap;
    }
}
