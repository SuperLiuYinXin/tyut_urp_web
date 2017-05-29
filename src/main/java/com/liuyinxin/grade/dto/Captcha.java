package com.liuyinxin.grade.dto;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

/**
 * @Author LiuYinXin
 * Created at 2017/5/18.17:08.
 */
public class Captcha implements Header{

    private String savePath;

    private String cookies;

    public Captcha(){

    }

    public Captcha(String savePath, String JSESSIONID) {
        this.savePath = savePath;
        this.cookies = JSESSIONID;
    }

    public String getSavePath() {
        return savePath;
    }


    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getCookies() {
        return cookies;
    }

    @Override
    public String toString() {
        return "Captcha{" +
                "savePath='" + savePath + '\'' +
                ", cookies='" + cookies + '\'' +
                '}';
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    /**
     * Get the name of the Header.
     *
     * @return the name of the Header,  never {@code null}
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Get the value of the Header.
     *
     * @return the value of the Header,  may be {@code null}
     */
    @Override
    public String getValue() {
        return null;
    }

    /**
     * Parses the value.
     *
     * @return an array of {@link HeaderElement} entries, may be empty, but is never {@code null}
     * @throws ParseException in case of a parsing error
     */
    @Override
    public HeaderElement[] getElements() throws ParseException {
        return new HeaderElement[0];
    }
}
