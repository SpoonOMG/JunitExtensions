package framework.qa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public final class JsonLoader {
    private final ReentrantLock lock = new ReentrantLock();
    private volatile String cachedJson;

    public synchronized String getJsonFromResources(String resourcePath) throws IOException {
        lock.lock();
        try {
            if (cachedJson == null || cachedJson.isEmpty()) {
                cachedJson = loadJsonFromResources(resourcePath);
            }
            return cachedJson;
        } finally {
            lock.unlock();
        }
    }

    private String loadJsonFromResources(String resourcePath) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        return stringBuilder.toString();
    }

    public void clearCache() {
        lock.lock();
        try {
            this.cachedJson = null;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonLoader)) return false;
        JsonLoader that = (JsonLoader) o;
        return Objects.equals(cachedJson, that.cachedJson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cachedJson);
    }
}