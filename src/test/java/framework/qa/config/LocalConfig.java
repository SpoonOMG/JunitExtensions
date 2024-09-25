package framework.qa.config;

public class LocalConfig implements Config {

    static final LocalConfig instance = new LocalConfig();

    private LocalConfig() {
    }
    @Override
    public String baseUrl() {
        return "http://localhost:8080/";
    }

    @Override
    public String wiremockUrl() {
        return "http://localhost:8082/";
    }

    public String token() {
        return "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJncGJ1OTY1MCIsInByb2ZpbGU6bG9naW4iOiJncGJ1OTY1MCIsImlzcyI6Imh0dHBzOi8vZ2F6cHJvbWJhbmsucnUvcGFzc3BvcnQiLCJwcm9maWxlOnRpdGxlIjoi0YDRg9C60L7QstC-0LTQuNGC0LXQu9GMINGN0LrRgdC_0LXRgNGC0LjQt9GLINC_0L4g0YLQtdGB0YLQuNGA0L7QstCw0L3QuNGOIiwicHJvZmlsZTptYWlsIjoiYW5kcmV5LnYuZWZpbW92QGdhenByb21iYW5rLnJ1IiwiYXV0aDpzZXJ2aWNlIjoic3NvIiwiYXV0aDptb2R1bGUiOiJzc28iLCJhdXRoOnRpbWUiOjE2MDYyMTczMDAsInByb2ZpbGU6ZGVwYXJ0bWVudCI6ItCU0LXQv9Cw0YDRgtCw0LzQtdC90YIg0YDQsNC30LLQuNGC0LjRjyDQvtC80L3QuNC60LDQvdCw0LvRjNC90L7QuSDQv9C70LDRgtGE0L7RgNC80YsiLCJhdXRoOnRpbWU6bWF4OmlkbGUiOjE2MDYyMjQ2MzgsImV4cCI6MTYwNjIxNzQ5OCwiaWF0IjoxNjA2MjE3NDM4LCJwcm9maWxlOm1lbWJlcm9mIjoiQXBwLU5CTy1QLUZPLEFwcC1VRk9fRk9fVXNlcl9URVNULEFwcC1KYWJiZXItTW9iaWxlLEFwcC1VRk9fRk9fVXNlcixBcHAtS1NNLVAtVXNlcixBcHAtTkJPLVAtRk8tVEVTVCxBcHAtYXNhLXVzciIsInByb2ZpbGU6ZnVsbE5hbWUiOiLQldGE0LjQvNC-0LIg0JDQvdC00YDQtdC5INCS0LDRgdC40LvRjNC10LLQuNGHIiwiaXAiOiIxMC45Ni42Ny4xNjEiLCJhdXRoOnRva2VuOmVuY3J5cHQiOiJBUUlDQzhiRTBFK2s2WWl4bGdmbkdSRnBrNEpjUURUMlk0YWNlSDZsTEllSjQyRVAzMm1mM0prYTNQaVAvVm96ZWxqY2NSWnMrdEtMbUU1bWhCRXl0ZUwrdjFNN0NnVE5teEVJMUEwcWNXdjdXOERBemFRMkNYVndsdjVUM3Zqck51WkRqNEZiTC9Na294Y2tmOFliTHlGQTNGdGdZTlIrbHJpZyIsInByb2ZpbGU6ZGl2aXNpb24iOiLQo9C_0YDQsNCy0LvQtdC90LjQtSDRgtC10YXQvdC-0LvQvtCz0LjQuSDQutC70LjQtdC90YLRgdC60LjRhSDQvtC80L3QuNC60LDQvdCw0LvRjNC90YvRhSDRgdC10YDQstC40YHQvtCyIiwibm9uY2UiOiJmNzY5MDNhYi03ZThhLTQwMWUtOTE4Mi1iNWQyMWM2MjI2ZWQiLCJhdWQiOiJodHRwczovL2dhenByb21iYW5rLnJ1L3Bhc3Nwb3J0IiwiYXV0aDpsZXZlbCI6IjAiLCJhdXRoOnRpbWU6bWF4IjoxNjA2MjYwNDk3LCJyZWFsbSI6Ii9zdGFmZiIsImF1dGg6Y3R4aWQiOiI3ZmU4ZjM4ZjUyNmQ0NGEwMjgiLCJqdGkiOiI2NmIwNmFhOC03N2IzLTRhZjktOGZkMC03NWQ4NDBlODM0NjUiLCJzdGF0dXMiOiJ0cnVlIn0.HxLj9fVONLLDWXR5-cS1GC0-hsaWyAgGDchGDWpcAjs865zBKNXCCpZkVfjNbq4P0H8MVp4FV7dzXDzoz_BgCZsGYYRufM_TXr2ctYheB8CIKfSj2HgsfYnHm00LGapPXwCv0LLV3vsJONlQc5t5rwVAKPW4whKV3TjUHlW3s7zq0Dwob2NySD4wpuzONty2ofsUsHZA5_KkAWn8y5fkr_lX031AGW7VKf49lQe0Wmz78OO-wLP-J0ok8ZjToi4Z8pNatvHQevmy9sVFYQZiOnkacdp9EyCRxIud0uG1CaPKX0nhk4lN5BqGC4_1afXzl1p0EUqvHRd2CyoSWZFYSw";
    }

    @Override
    public String mqHost() {
        return "localhost";
    }

    @Override
    public Integer port() {
        return 1414;
    }

    @Override
    public String queueManager() {
        return "QM1";
    }

    @Override
    public String channel() {
        return "DEV.APP.SVRCONN";
    }

    @Override
    public String mq_appName() {
        return "app";
    }

    @Override
    public String pass() {
        return "passw0rd";
    }

    @Override
    public String user() {
        return "app";
    }


}
