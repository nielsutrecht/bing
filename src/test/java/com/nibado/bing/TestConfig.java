package com.nibado.bing;

import junit.framework.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static Logger LOG = LoggerFactory.getLogger(TestConfig.class);
    private Properties properties;

    private TestConfig() {
        properties = new Properties();

        try {
            properties.load(TestConfig.class.getResourceAsStream("/test.properties"));
        }
        catch(IOException e) {
            LOG.error("Could not load test.properties file from classpath: {}", e.getMessage());
        }
    }

    public String apiKey() {
        return properties.getProperty("apiKey");
    }

    public static TestConfig get() {
        if(current == null) {
            current = new TestConfig();
        }

        return current;
    }

    private static TestConfig current;
}
