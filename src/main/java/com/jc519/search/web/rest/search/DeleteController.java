package com.jc519.search.web.rest.search;

import com.jc519.search.service.search.DeleteService;
import com.jc519.search.service.search.imp.SearchImportServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "删除索引", tags = "删除索引")
@RestController
public class DeleteController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchImportServiceImp.class);

    @Autowired
    private DeleteService deleteService;

    /**
     * 删除控销商品索引
     */
    @ApiOperation(value = "删除控销商品索引", notes = "删除控销商品索引")
    @RequestMapping(value = "deleteControlIndex", method = RequestMethod.DELETE)
    public String deleteControlIndex() {
        logger.info("删除中");
        try {
            deleteService.deleteControlIndex();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "删除完成";
    }

    /**
     * 删除集采商品索引
     */
    @ApiOperation(value = "删除集采商品索引", notes = "删除集采商品索引")
    @RequestMapping(value = "deleteNoControlIndex", method = RequestMethod.DELETE)
    public String deleteNoControlIndex() {
        logger.info("删除中");
        try {
            deleteService.deleteNoControlIndex();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "删除完成";
    }

    /**
     * 删除热词索引
     */
    @ApiOperation(value = "删除热词索引", notes = "删除热词索引")
    @RequestMapping(value = "deleteHotWordsIndex", method = RequestMethod.DELETE)
    public String deleteHotWordsIndex() {
        logger.info("删除中");
        try {
            deleteService.deleteHotWordsIndex();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "删除完成";
    }
}
