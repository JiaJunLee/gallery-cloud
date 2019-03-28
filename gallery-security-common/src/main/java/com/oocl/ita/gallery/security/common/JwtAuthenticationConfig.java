package com.oocl.ita.gallery.security.common;


import org.springframework.beans.factory.annotation.Value;

public class JwtAuthenticationConfig {

    @Value("${security.jwt.url:/user/login}")
    private String url;

    @Value("${security.jwt.cookie:Authorization}")
    private String cookie;

    @Value("${security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${security.jwt.secret}")
    private String secret;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationConfig{" +
                "url='" + url + '\'' +
                ", cookie='" + cookie + '\'' +
                ", prefix='" + prefix + '\'' +
                ", expiration=" + expiration +
                ", secret='" + secret + '\'' +
                '}';
    }
}
