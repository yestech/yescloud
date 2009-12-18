package org.yestech.cloud.service;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.compass.core.Compass;
import org.compass.core.CompassIndexSession;
import org.compass.core.CompassSearchSession;
import org.compass.core.CompassSession;
import org.springframework.beans.factory.annotation.Required;
import org.yestech.cache.ICacheManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Manages all Compass instances and caches each instance by userGuid.
 */
public class CompassManager {
    private static Log logger = LogFactory.getLog(CompassManager.class);
    private String rootDir = "target/test-index";
    private Properties compassProperties;
    private String connectionType = "niofs://";
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    @Resource(name = "compassPool")
    private ICacheManager<String, Compass> compassPool;

    public CompassManager() {
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public ICacheManager<String, Compass> getCompassPool() {
        return compassPool;
    }

    public void setCompassPool(ICacheManager<String, Compass> compassPool) {
        this.compassPool = compassPool;
    }

    @Required
    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        if (!StringUtils.endsWithIgnoreCase(rootDir, "/")) {
            rootDir += "/";
        }
        this.rootDir = rootDir;
    }

    public Properties getCompassProperties() {
        return compassProperties;
    }

    public void setCompassProperties(Properties compassProperties) {
        this.compassProperties = compassProperties;
    }

    @PostConstruct
    public void initialize() {
        File root = new File(rootDir);
        if (logger.isInfoEnabled()) {
            logger.info("Reading rootDir: " + rootDir);
        }
        if (!root.exists()) {
            root.mkdirs();
        }
        String[] rootList = root.list();
        if (rootList != null) {
            for (String item : rootList) {
                File possibleDir = new File(item);
                if (possibleDir.isDirectory()) {
                    String userGuid = "";
                    if (StringUtils.startsWithIgnoreCase(item, rootDir)) {
                        userGuid = StringUtils.split(item, rootDir)[0];
                    }
                    userGuid = StringUtils.split(userGuid, "/")[0];
                    if (logger.isInfoEnabled()) {
                        logger.info("userGuid loading: " + userGuid);
                    }
                    Compass compass = createNewCompass(userGuid);
                    compassPool.put(userGuid, compass);
                }
            }
        }
    }

    private Compass createNewCompass(String userGuid) {
        String compassConnection = connectionType + rootDir + userGuid;
        if (logger.isInfoEnabled()) {
            logger.info("setting compass Connection property: " + compassConnection);
        }
        Properties mergedProperties = new Properties(compassProperties);
        mergedProperties.put("compass.engine.connection", compassConnection);
        return CompassFacory.create("org.yestech.cloud.objectmodel", mergedProperties);
    }

    @PreDestroy
    public void shutdown() {
        for (Compass compass : compassPool.values()) {
            compass.close();
        }
        compassPool.flushAll();
    }

    public Compass getCompass(String userGuid) {
        Compass compass = null;
        try {
            r.lock();
            compass = compassPool.get(userGuid);
        } finally {
            r.unlock();
        }
        if (compass == null) {
            try {
                w.lock();
                if (compassPool.get(userGuid) == null) {
                    compass = createNewCompass(userGuid);
                    compassPool.put(userGuid, compass);
                }
            } finally {
                w.unlock();
            }
        }
        return compass;
    }

    public CompassIndexSession getIndexWriter(String userGuid) {
        Compass compass = getCompass(userGuid);
        return compass.openIndexSession();
    }

    public CompassSearchSession getIndexSearcher(String userGuid) {
        Compass compass = getCompass(userGuid);
        return compass.openSearchSession();
    }

    public CompassSession getSearcher(String userGuid) {
        Compass compass = getCompass(userGuid);
        return compass.openSession();
    }
}
