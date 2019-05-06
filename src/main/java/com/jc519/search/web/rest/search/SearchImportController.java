package com.jc519.search.web.rest.search;

import com.jc519.search.service.search.DeleteService;
import com.jc519.search.service.search.SearchImportService;
import com.jc519.search.web.rest.search.param.UpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jc519.search.service.search.imp.SearchImportServiceImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Api(value = "导入索引库",tags = "导入索引库")
@RestController
public class SearchImportController {

	@Autowired
    SearchImportService searchImportService;


	@Autowired
    private RedisTemplate redisTemplate;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchImportServiceImp.class);


    @ApiOperation(value = "更新商品索引库",notes = "更新商品时更新索引库")
    @RequestMapping(value = "/updateIndexStorage", method = RequestMethod.GET)
    //@Scheduled(cron="0 0/5 * * * ?")
    public String updateIndexStorage() {
        logger.info("=========================开始更新==================================");
        try {
                searchImportService.updateIndex();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        return "更新完成";
    }


    @ApiOperation(value = "全量导入商品索引库",notes = "全量导入商品索引库")
    @RequestMapping(value = "/importIndexStorage", method = RequestMethod.GET)
    public String importIndexStorage() {
        logger.info("=========================开始导入==================================");
        try {
            searchImportService.importData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //添加这次的更新时间
        ValueOperations ops = redisTemplate.opsForValue();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        form.format(date);
        String lastIndexTime = date.toString();
        ops.set("lastIndexTime",lastIndexTime);
        return "全量导入完成";
    }
  /*  @ApiOperation(value = "全量导入控销上采目录",notes = "全量导入控销上采目录")
    @RequestMapping(value = "/importPurchaseMedicineGoods", method = RequestMethod.GET)
    public String importControlPurchase() {
        System.out.println("导入中");
        try {
            return searchImportService.importControlPurchase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "全量导入完成";
    }*/
}
