package org.yestech.cloud.service;

import org.yestech.cloud.objectmodel.ICloud;
import org.yestech.cloud.objectmodel.CloudItem;
import org.yestech.cloud.objectmodel.IViewableCloud;

import java.util.UUID;
import java.util.List;

/**
 *
 *
 */
public interface ISearchService {
  <S> void postCloudItem(ICloud<S> cloud);

    IViewableCloud viewCloud(String userGuid);

    List<CloudItem> viewCloudItems(String userGuid, String text);
}
