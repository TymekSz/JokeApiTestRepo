package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

public class DataTableConfig {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }
}