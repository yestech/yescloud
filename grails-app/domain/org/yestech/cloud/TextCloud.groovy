package org.yestech.cloud

import org.yestech.cloud.HibernateTag
import org.grails.taggable.Taggable

/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
//@NamedQueries
//({
//	@NamedQuery(name = "Article.All", query = "from Article a order by a.creationDate desc"),
//	@NamedQuery(name = "Article.ByTag", query = "from Article a where ? in elements(a.tags) order by a.creationDate desc"),
//	@NamedQuery(name = "Article.BeforeDate", query = "from Article a where a.creationDate < ? order by a.creationDate desc"),
//	@NamedQuery(name = "Article.ByTagBeforeDate", query = "from Article a where ? in elements(a.tags) and a.creationDate < ? order by a.creationDate desc"),
//	@NamedQuery(name = "Article.CountBeforeDate", query = "select count(a.id) from Article a where a.creationDate < ?"),
//	@NamedQuery(name = "Article.CountByTagBeforeDate", query = "select count(a.id) from Article a where ? in elements(a.tags) and a.creationDate < ?"),
//	@NamedQuery(name = "Article.BetweenDates", query = "from Article a where a.creationDate >= ? and a.creationDate < ? order by a.creationDate desc"),
//	@NamedQuery(name = "Article.ByTagBetweenDates", query = "from Article a where ? in elements(a.tags) and a.creationDate >= ? and a.creationDate < ? order by a.creationDate desc"),
//	@NamedQuery(name = "Article.ByPermalink", query = "from Article a where a.permalink = ?")
//})
public class TextCloud implements Taggable {
  private String permlink
}