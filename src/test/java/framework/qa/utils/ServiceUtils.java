package framework.qa.utils;

import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.ScreenValueBack;

import java.util.*;

public class ServiceUtils {
    public String gbpRequestId = UUID.randomUUID().toString();

    /**
     * Метод извлекает значение из списка значений
     *
     * @param values список значений
     * @param code   ключ
     * @return значение
     */
    public static Optional<ValuesItem> extractValue(List<ValuesItem> values, String code) {
        return Optional.ofNullable(values).orElse(Collections.emptyList()).stream()
                .filter(elem -> elem.getId().equals(code))
                .findFirst();
    }

    public static List<ScreenValueBack> replaceValueInOperation(List<ScreenValueBack> values, String id, String expectedValues) {
        values.stream()
                .filter(value-> Objects.equals(id,value.getId()))
                .forEach(value->value.setValue(expectedValues));
        return values;
    }


}
