package com.jc519.search.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 搜素热词计数表
 * 实体类对应的数据表为：  jc_search_hot_words
 * @author XZHH
 * @create 2018/1/27 0027 17:45
 **/
@ApiModel(value = "SearchHotWordsCount")
public class SearchHotWordsCount {

    @ApiModelProperty(value = "热词id")
    private Integer id;

    @ApiModelProperty(value = "搜索热词")
    private Integer hotWord;

    @ApiModelProperty(value = "累计数量")
    private Integer count;

    @ApiModelProperty(value = "上次搜索时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSearchTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotWord() {
        return hotWord;
    }

    public void setHotWord(Integer hotWord) {
        this.hotWord = hotWord;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLastSearchTime() {
        return lastSearchTime;
    }

    public void setLastSearchTime(Date lastSearchTime) {
        this.lastSearchTime = lastSearchTime;
    }
}
