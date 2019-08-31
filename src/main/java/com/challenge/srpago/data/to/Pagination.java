package com.challenge.srpago.data.to;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/30/19<br/>
 * Time: 9:47 PM<br/>
 * Generated to
 */
public class Pagination {
    private Integer pageSize;
    private Integer page;
    private Integer total;

    public Pagination(Integer pageSize, Integer page, Integer total) {
        this.pageSize = pageSize;
        this.page = page;
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
