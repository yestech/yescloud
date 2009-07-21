package org.yestech.cloud

/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
public interface TagDao extends TagDaoBase
{
  public HibernateTag findByName(String name);
  public List<HibernateTag> listAll();
  public List<HibernateTag> listAllInRange(int start, int limit);
  public int countAll();

}