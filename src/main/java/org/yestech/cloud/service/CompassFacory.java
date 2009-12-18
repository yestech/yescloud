package org.yestech.cloud.service;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassConfigurationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 *
 *
 */
public class CompassFacory {
    final private static Logger logger = LoggerFactory.getLogger(CompassFacory.class);

    public static Compass create(String mappingScan, Properties compassSettings) {
        CompassConfiguration config = CompassConfigurationFactory.newConfiguration();
        config.addScan(mappingScan);

        config.getSettings().addSettings(compassSettings);
        return config.buildCompass();
    }
}
