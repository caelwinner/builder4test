package uk.co.caeldev.builder4test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

public class Lookup {

    Map<String, Value> fields;

    Lookup() {
        this.fields = new HashMap<>();
    }

    void add(Value field) {
        fields.put(field.fieldId, field);
    }

    public <K> K get(String fieldName, K defaultValue) {
        Optional<Value> optionalValue = Optional.ofNullable(fields.get(fieldName));

        if (!optionalValue.isPresent()) {
            return defaultValue;
        }

        return isNull(optionalValue.get().getValue())? defaultValue : (K)optionalValue.get().getValue();
    }
}