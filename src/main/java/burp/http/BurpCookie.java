package burp.http;

import biz.netcentric.aem.securitycheck.http.Cookie;
import burp.ICookie;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Wraps the ICookie interface.
 */
public class BurpCookie implements Cookie {

    private final String domain;
    private final String value;
    private final String path;
    private final Date expiration;
    private final String name;

    public BurpCookie(final ICookie cookie) {
        this.path = cookie.getPath();
        this.name = cookie.getName();
        this.expiration = cookie.getExpiration();
        this.value = cookie.getValue();
        this.domain = cookie.getDomain();
    }

    @Override
    public String domain() {
        return this.domain;
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Date expirationTime() {
        return this.expiration;
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("domain", this.domain);
        properties.put("path", this.path);
        properties.put("value", this.value);
        properties.put("name", this.name);
        return properties;
    }
}
