package org.yestech.cloud.objectmodel;

import java.io.Serializable;

/**
 * Represents an element in the {@link DefaultViewableCloud}.
 */
public class CloudItem implements Serializable {

    private String tag;
    private int frequency;
    private static final long serialVersionUID = -4109505551526405700L;

    public CloudItem() {
    }

    public CloudItem(String tag, int frequency) {
        this.tag = tag;
        this.frequency = frequency;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public static CloudItem createItem(String tag, int frequency) {
        return new CloudItem(tag, frequency);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CloudItem cloudItem = (CloudItem) o;

        if (frequency != cloudItem.frequency) return false;
        if (tag != null ? !tag.equals(cloudItem.tag) : cloudItem.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + frequency;
        return result;
    }

    @Override
    public String toString() {
        return "CloudItem{" +
                "tag='" + tag + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    public static CloudItem createItem(String tag, float freq) {
        return createItem(tag, (int)freq);
    }
}
