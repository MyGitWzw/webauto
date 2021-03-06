package com.webauto.pojo;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 10:34
 */
public class UIElement {
    private String keyword;
    private String by;
    private String value;

    public UIElement() {
    }

    public UIElement(String keyword, String by, String value) {
        this.keyword = keyword;
        this.by = by;
        this.value = value;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
