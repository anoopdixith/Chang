package com.kennedy.DesignPatterns.URLShortener;

/**
 * Created by adixith on 12/24/16.
 */
public class Link {
    private String shortLink;
    private String longLink;
    public Link() {
        throw new IllegalArgumentException();
    }
    public Link(String longLink) {
        this(getAutomatedShortLink(longLink), longLink);
    }
    public Link(String shortLink, String longLink) {
        this.longLink = longLink;
        this.shortLink = shortLink;
    }

    private static String getAutomatedShortLink(String longLink) {
        return "";
    }
}
