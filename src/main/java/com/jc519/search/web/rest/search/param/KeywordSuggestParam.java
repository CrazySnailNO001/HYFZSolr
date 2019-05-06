package com.jc519.search.web.rest.search.param;

import io.swagger.annotations.ApiModelProperty;

public class KeywordSuggestParam {

    @ApiModelProperty(value="关键词")
    private String keyword;

    @ApiModelProperty(value="1-PC端 2-APP端")
    private Integer type;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
