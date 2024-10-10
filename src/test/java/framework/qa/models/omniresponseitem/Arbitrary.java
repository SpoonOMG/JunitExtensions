package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

public class Arbitrary{
    public Location getLocation() {
        return location;
    }

    public Office getOffice() {
        return office;
    }

    public MiddleOfficeDsa getMiddleOfficeDsa() {
        return middleOfficeDsa;
    }

    public CourierTime getCourierTime() {
        return courierTime;
    }

    public VirtualBranches getVirtualBranches() {
        return virtualBranches;
    }

    public CurrencyUnionPay getCurrencyUnionPay() {
        return currencyUnionPay;
    }

    /**
     * Список городов доставки
     */
    private Location location;

    /**
     * Список офисов
     */
    private Office office;

    /**
     * Список мидл офисов DSA
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MiddleOfficeDsa middleOfficeDsa;

    /**
     * Список времени доставки курьером
     */
    private CourierTime courierTime;

    /**
     * Место обслуживания карты
     */
    private VirtualBranches virtualBranches;

    /**
     * Доступные валюты цифровой карты для платежной системы UnionPay
     */
    private CurrencyUnionPay currencyUnionPay;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        public List<Record> getRecords() {
            return records;
        }

        private List<Record> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Office {
        public List<Record> getRecords() {
            return records;
        }

        private List<Record> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MiddleOfficeDsa {
        public List<Record> getRecords() {
            return records;
        }

        private List<Record> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CourierTime {
        private List<Map<String, String>> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VirtualBranches {
        private List<Record> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrencyUnionPay {
        private List<Record> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdditionalCard {
        private String commissionValue;
        private String isBalanceSufficient;
        private String printCardName;
    }
}