package org.yestech.cloud.objectmodel;

import java.io.Serializable;

/**
 *
 *
 */
public interface IViewableCloud extends Serializable, Iterable<CloudItem> {
    String getLink();

    void setLink(String link);

    void addItem(CloudItem item);

    void removeItem(CloudItem item);
}
