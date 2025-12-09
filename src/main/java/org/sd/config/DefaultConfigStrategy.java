package org.sd.config;


import org.sd.interfaces.IConfigStrategy;

public class DefaultConfigStrategy implements IConfigStrategy {
    @Override
    public String getConfig(String key) {
        return System.getenv(key);
    }
}
