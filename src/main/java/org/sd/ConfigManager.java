package org.sd;


import org.sd.config.DefaultConfigStrategy;
import org.sd.interfaces.IConfigStrategy;

public class ConfigManager {

    private IConfigStrategy configStrategy= new DefaultConfigStrategy ();
    public String getConfig(String key) {
        return configStrategy.getConfig(key);
    }

    public String getConfig(String key, String defaultValue) {
        String value = getConfig(key);
        return value != null ? value : defaultValue;
    }

    public void setConfigStrategy(IConfigStrategy configStrategy) {
        this.configStrategy = configStrategy;
    }
}
