/*
 * Copyright LGPL3
 * YES Technology Association
 * http://yestech.org
 *
 * http://www.opensource.org/licenses/lgpl-3.0.html
 */

package org.yestech.cloud.objectmodel;

import org.yestech.lib.crypto.MessageDigestUtils;
import static org.yestech.lib.crypto.MessageDigestUtils.sha1Hash;

import java.util.UUID;

/**
 * Factory to create {@link org.yestech.cloud.objectmodel.ICloud}.
 *
 */
public class CloudFactory {
    public static ICloud<String> create(String key, String content) {
        AsciiCloud cloud = new AsciiCloud();
        cloud.setGuid(sha1Hash(UUID.randomUUID().toString()));
        cloud.setOwner(key);
        cloud.setSource(content);
        return cloud;
    }
}
