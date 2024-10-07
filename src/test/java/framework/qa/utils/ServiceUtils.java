package framework.qa.utils;

import framework.qa.models.omniresponseitem.ValuesItem;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ServiceUtils {

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
}
