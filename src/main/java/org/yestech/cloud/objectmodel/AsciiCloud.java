package org.yestech.cloud.objectmodel;

import org.compass.annotations.*;
import org.compass.core.engine.subindex.ModuloSubIndexHash;

/**
 * Represents a cloud from
 *
 */
@Searchable(alias = "asciiCloud")
@SearchableSubIndexHash(value = ModuloSubIndexHash.class,
        settings = { @SearchSetting(name = "prefix", value = "cloud_subIdx"), @SearchSetting( name = "size", value = "10")})
public class AsciiCloud implements ICloud<String> {
    private static final long serialVersionUID = -8191224640459545622L;

    @SearchableId
    private String guid;

    @SearchableProperty(store = Store.YES)
    private String userGuid;

    @SearchableProperty(termVector = TermVector.YES, store = Store.YES)
    private String text;

    @Override
    public void setOwner(String userGuid) {
        this.userGuid = userGuid;
    }

    @Override
    public void setSource(String source) {
        setText(source);
    }

    @Override
    public String getOwner() {
        return userGuid;
    }

    @Override
    public String getSource() {
        return getText();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
