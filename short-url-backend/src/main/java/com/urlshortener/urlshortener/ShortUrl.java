package com.urlshortener.urlshortener;

import java.io.Serializable;

public class ShortUrl implements Serializable {
    private String fullUrl;
    private String shortUrl;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
