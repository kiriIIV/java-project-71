package formatters;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrepareDataForJson {
    private Object key;
    private Object oldValue;
    private Object newValue;
    private Object value;
    private Object statusKey;

    PrepareDataForJson(Object key, Object oldValue, Object newValue, Object statusKey) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.statusKey = statusKey;
    }

    PrepareDataForJson(Object key, Object value, Object statusKey) {
        this.key = key;
        this.value = value;
        this.statusKey = statusKey;
    }

    public Object getKey() {
        return key;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public Object getStatusKey() {
        return statusKey;
    }

    public Object getValue() {
        return value;
    }
}
