package com.jc519.search.web.rest.search.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author XZHH
 * @create 2018/1/24 0024 20:47
 **/
public class PageParam {
    @ApiModelProperty(value = "页码")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页大小")
    private int pageSize =20;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
