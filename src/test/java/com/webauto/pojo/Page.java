package com.webauto.pojo;

import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 10:31
 */
public class Page {
    private String keyword;
    private List<UIElement> uiElementList;

    public Page() {
    }

    public Page(String keyword, List<UIElement> uiElementList) {
        this.keyword = keyword;
        this.uiElementList = uiElementList;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<UIElement> getUiElementList() {
        return uiElementList;
    }

    public void setUiElementList(List<UIElement> uiElementList) {
        this.uiElementList = uiElementList;
    }
}
