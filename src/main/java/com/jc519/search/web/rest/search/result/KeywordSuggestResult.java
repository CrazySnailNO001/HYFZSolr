package com.jc519.search.web.rest.search.result;

import io.swagger.annotations.ApiModelProperty;

public class KeywordSuggestResult {

    @ApiModelProperty(value = "关键词")
    private String keyword;

    @ApiModelProperty(value = "关键词（高亮显示的html）")
    private String suggestWord;

    @ApiModelProperty(value = "数量")
    private long num;

    @ApiModelProperty(value = "类型 1-集采 2-控销")
    private Integer type;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSuggestWord() {
        return suggestWord;
    }

    public void setSuggestWord(String suggestWord) {
        this.suggestWord = suggestWord;
    }

}
