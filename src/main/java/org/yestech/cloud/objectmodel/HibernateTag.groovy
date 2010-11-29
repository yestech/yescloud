package org.yestech.cloud.objectmodel

import org.grails.taggable.Taggable
/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */

//@NamedQueries
//({
//  @NamedQuery(
//    name = "HibernateTag.All",
//    query = "from HibernateTag t order by t.displayName"),
//  @NamedQuery(
//    name = "HibernateTag.CountAll",
//    query = "select count(t.id) from HibernateTag t"),
//  @NamedQuery(
//    name = "HibernateTag.ByName",
//    query = "from HibernateTag t where t.name = ?"),
//  @NamedQuery(
//    name = "HibernateTag.AllTagStatistics",
//    query = "select t, t.articles.size from HibernateTag t
//         order by t.displayName"),
//  @NamedQuery(
//    name = "HibernateTag.MostArticles",
//    query = "select max(t.articles.size) from HibernateTag t")
//})
//public class HibernateTag implements Serializable, Comparable<HibernateTag> {
public class HibernateTag implements Serializable {
  /**
       * HibernateTag Comparator (by name).
       */
//      public static final Comparator<HibernateTag> NAME_COMPARATOR = new Comparator<HibernateTag>()
//      {
//          public int compare(HibernateTag t1, HibernateTag t2)
//          {
//              String s1 = StringUtils.trimToEmpty(t1.getName());
//              String s2 = StringUtils.trimToEmpty(t2.getName());
//              return s1.compareTo(s2);
//          }
//      };

      /**
       * HibernateTag Comparator (by display name).
       */
//      public static final Comparator<HibernateTag> DISPLAY_NAME_COMPARATOR = new Comparator<HibernateTag>()
//      {
//          public int compare(HibernateTag t1, HibernateTag t2)
//          {
//              String s1 = StringUtils.trimToEmpty(t1.getDisplayName());
//              String s2 = StringUtils.trimToEmpty(t2.getDisplayName());
//              return s1.compareTo(s2);
//          }
//      };

//      private Long id;
//      private String name;
//      private String displayName;

//      private transient List<ICloudArtifacts> cloudArtifacts;

//      static belongsTo = Sentence
//      static hasMany = [sentences:Sentence]

/**
	 * Compares this HibernateTag to another HibernateTag by name.
	 * @return 0 if equal, -1 if this is before, 1 if this is after
	 */
//	public int compareTo(HibernateTag o)
//	{
//		return NAME_COMPARATOR.compare(this, o);
//	}

	/**
	 * Gets a string representation of this object, suitable for debugging.
	 * @return string representation of this object
	 */
//	@Override
//	public String toString()
//	{
//		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//	}
}