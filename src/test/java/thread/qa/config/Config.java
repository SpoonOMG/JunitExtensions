package thread.qa.config;

public interface Config {

    static Config getInstance() {
        if ("local".equals(System.getProperty("test.env", "local"))) {
            return LocalConfig.instance;
        } else if ("openShift".equals(System.getProperty("test.env"))) {
            return OpenShiftConfig.instance;
        } else {
            throw new IllegalStateException("Can not find Config for given env");
        }
    }

    String baseUrl();
    String wiremockUrl();
    String token();

}
