package com.zr.util;

import java.util.List;

public class PageBean<T> {

    private int count;
    private int pageCount;
    private int pageIndex;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getPages() {
        return (count+pageCount-1)/pageCount;
    }

    /**
     * 获取数据索引值
     * @return
     */
    public int getIndex() {
        return (pageIndex-1)*pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
