package org.yestech.cloud.search

import org.yestech.cloud.TextCloud
import org.yestech.cloud.TextCloud

//import org.yestech.cloud.TagStatistics
//import org.yestech.cloud.TagCloudEntry
/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */

public class TextCloudService {
//  def tinyurlService

  def save(TextCloud textCloud) {
//      def post = new Post(params)
////save your post
//def newUrl = tinyurlService.tiny(post.link)
//
////set your twitter status
//twitter.post("I've just posted about ${post.title} right here: ${newUrl}")

    textCloud.save();
  }

  def load(id) {
    return TextCloud.get(id);
  }

  def loadByTag(key, tag) {
    return TextCloud.findAllByTag(tag);
  }

  def loadCloud(key) {
      TextCloud.termFreqs("tag", size : 10);
//    return TextCloud.get(id);
  }

// public List<TagCloudEntry> getTagCloud()
//  {
//    List<TagStatistics> tagStats = tagDao.queryAllTagStatistics();
//    int mostArticles = tagDao.queryMostArticles();
//
//    List<TagCloudEntry> cloud = new ArrayList<TagCloudEntry>(tagStats.size());
//
//    for (TagStatistics tag : tagStats)
//    {
//      if (tag.getArticleCount() > 0)
//        cloud.add(new TagCloudEntry(tag, mostArticles));
//    }
//    return cloud;
//  }

/*
	private TagDao tagDao;
	private ArticleDao articleDao;

	@Required
	public void setTagDao(TagDao tagDao)
	{
		this.tagDao = tagDao;
	}

	@Required
	public void setArticleDao(ArticleDao articleDao)
	{
		this.articleDao = articleDao;
	}

	public List<TagCloudEntry> getTagCloud()
	{
		List<TagStatistics> tagStats = tagDao.queryAllTagStatistics();
		int mostArticles = tagDao.queryMostArticles();

		List<TagCloudEntry> cloud = new ArrayList<TagCloudEntry>(tagStats.size());

		for (TagStatistics tag : tagStats)
		{
			if (tag.getArticleCount() > 0)
				cloud.add(new TagCloudEntry(tag, mostArticles));
		}

		return cloud;
	}

	@Transactional(readOnly=true)
	public void loadTagForEditing(Consumer<HibernateTag> consumer, Long tagId)
	{
		HibernateTag tag = loadTag(tagId);
		consumer.consume(tag);
	}

	@Transactional
	public void createTag(Producer<HibernateTag> producer)
	{
		HibernateTag tag = new HibernateTag();
		producer.produce(tag);
		tagDao.create(tag);
	}

	@Transactional
	public void updateTag(Producer<HibernateTag> producer, Long tagId)
	{
		HibernateTag tag = loadTag(tagId);
		producer.produce(tag);
		tagDao.update(tag);
	}

	@Transactional
	public void deleteTag(Long tagId)
	{
		HibernateTag tag = loadTag(tagId);

		// remove tag from all articles which it applies to
		// failing to do this will result in ObjectNotFoundExceptions
		// we use an iterator here because the list of articles could be large
		Iterator<Article> articles = articleDao.iterateByTag(tag);
		while (articles.hasNext())
		{
			Article article = articles.next();
			article.getTags().remove(tag);
		}

		tagDao.delete(tag);
	}

	private HibernateTag loadTag(Long tagId)
	{
		HibernateTag tag = tagDao.read(tagId);
		if (tag == null) throw new TagNotFoundException();
		return tag;
	}
	*/
}