package org.yestech.cloud.dao

import org.yestech.cloud.TagStatistics

/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
public interface TagDaoBase {
  public List<TagStatistics> queryAllTagStatistics()

  public List<TagStatistics> queryAllTagStatisticsInRange(int start, int limit)

  public int queryMostArticles()
}