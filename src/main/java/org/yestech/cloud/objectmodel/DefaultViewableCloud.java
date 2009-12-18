package org.yestech.cloud.objectmodel;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Iterator;
import java.util.List;

/**
 * This is the default implementation of a {@link org.yestech.cloud.objectmodel.IViewableCloud}.
 *
 */
public class DefaultViewableCloud implements IViewableCloud {

    private static final long serialVersionUID = -1186288998886163942L;
    private List<CloudItem> items = newArrayList();
    private String link;

    public String getLink() {

        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<CloudItem> getItems() {
        return items;
    }

    @Override
    public Iterator<CloudItem> iterator() {
        return items.iterator();
    }

    public void addItem(CloudItem item) {
        items.add(item);
    }

    public void removeItem(CloudItem item) {
        items.remove(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultViewableCloud that = (DefaultViewableCloud) o;

        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DefaultViewableCloud{" +
                "items=" + items +
                ", link='" + link + '\'' +
                '}';
    }
}
