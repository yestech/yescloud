package org.yestech.cloud.service;

import org.compass.core.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Required;
import static org.yestech.cloud.objectmodel.CloudItem.createItem;
import org.yestech.cloud.objectmodel.ICloud;
import org.yestech.cloud.objectmodel.DefaultViewableCloud;
import org.yestech.cloud.objectmodel.CloudItem;
import org.yestech.cloud.objectmodel.IViewableCloud;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/*
*
* Author:  Artie Copeland
* Last Modified Date: $DateTime: $
*/
@Service("searchService")
public class SearchService implements ISearchService {

    @Resource(name = "compassManager")
    private CompassManager compassManager;
    private int maxSize = 20;
    private String searchCallableLink;

    @Required
    public String getSearchCallableLink() {
        return searchCallableLink;
    }

    public void setSearchCallableLink(String searchCallableLink) {
        this.searchCallableLink = searchCallableLink;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public CompassManager getCompassManager() {
        return compassManager;
    }

    public void setCompassManager(CompassManager compassManager) {
        this.compassManager = compassManager;
    }

    @Override
    public <S> void postCloudItem(ICloud<S> cloud) {
        CompassIndexSession indexSession = compassManager.getIndexWriter(cloud.getOwner());
        try {
            indexSession.save(cloud);
        } finally {
            indexSession.close();
        }

    }

    @Override
    public IViewableCloud viewCloud(String userGuid) {
        IViewableCloud cloud = new DefaultViewableCloud();
        CompassSession searchSession = compassManager.getSearcher(userGuid);
        try {
            searchSession.beginLocalTransaction();
            cloud.setLink(searchCallableLink);
            CompassTermFreqsBuilder builder = searchSession.termFreqsBuilder("text");
            String subIndexes[] = compassManager.getCompass(userGuid).getSearchEngineIndexManager().getSubIndexes();
            builder.setSort(CompassTermFreqsBuilder.Sort.FREQ).setAliases("asciiCloud").setSubIndexes(subIndexes).setSize(maxSize);

            CompassTermFreq[] compassTermFreqs = builder.toTermFreqs();
            for (CompassTermFreq compassTermFreq : compassTermFreqs) {
                float freq = compassTermFreq.getFreq();
                String tag = compassTermFreq.getTerm();
                cloud.addItem(createItem(tag, freq));
            }
        } finally {
            searchSession.close();
        }
        return cloud;
    }

    @Override
    public List<CloudItem> viewCloudItems(String userGuid, String text) {
        return newArrayList();
    }
}