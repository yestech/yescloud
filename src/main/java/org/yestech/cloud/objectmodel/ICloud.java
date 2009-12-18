package org.yestech.cloud.objectmodel;

import java.io.Serializable;

/**
 * This is the Main Cloud.  It can be of any type source
 *
 */
public interface ICloud<S> extends Serializable {

    void setOwner(String userGuid);

    void setSource(S source);

    String getOwner();

    S getSource();
}
