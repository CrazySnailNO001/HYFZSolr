package com.jc519.search.web.rest.search.param;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author XZHH
 * @create 2018/1/28 0028 14:30
 **/
public class UpdateParam {
    @ApiModelProperty(value = "商品id -List<Integer>")
    private List<Integer> ids;

    @ApiModelProperty(value = "isControl 1-集采  2-控销")
    private Integer isControl;

    @ApiModelProperty(value = "类型 0-添加 1-删除  2-修改")
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsControl() {
        return isControl;
    }

    public void setIsControl(Integer isControl) {
        this.isControl = isControl;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
