package com.jc519.search.config;

import com.fasterxml.classmate.TypeResolver;
import com.jc519.common.security.token.TokenConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Header;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@EnableSwagger2
//@Import({BeanValidatorPluginsConfiguration.class})
//@Import({SpringDataRestConfiguration.class})
public class Swagger2Config {

    @Value("${api.host}")
    private String host;

    @Bean
    public Docket petApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(TokenConfigurer.AUTHORIZATION_HEADER).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .host(host)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.jc519.search.web.rest.search")) // 指定的包生成文档
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .globalOperationParameters(pars)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList());
    }

    private List<ResponseMessage> newArrayList() {
        List<ResponseMessage> res = new ArrayList<ResponseMessage>();
        res.add(new ResponseMessageBuilder()
                .code(201)
                .message("Created")
                //.responseModel(new ModelRef("Error"))
                //.headersWithDescription(new HashMap<String,Header>().put("Location",new Header("","/**/{id}",null))
                .headersWithDescription(header())
                .build());
        return res;
    }

    private Map<String,Header> header() {
        Map<String,Header> headerMap = new HashMap<>();
        Header header = new Header("","/**/{id}",new ModelRef("Success"));
        headerMap.put("location",header);
        return headerMap;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("通药集採API接口")
                .description("提供药品、库存等API.</br>通用说明：</br>1.后台返回的所有的列表都是分页形式，分页" +
                        "参数pageNum,pageSize非必传，不传pageNum默认是1，pageSize默认是20，" +
                        "当下拉列表时，pageNum=1,pageSize=100，当全部数据超出100条时，应该考虑分页处理.</br>2.put/patch 的资源主键id" +
                        "应该放到路径中（{id}）,当model 中也有主键时，以路径中为准。后端处理会用路径中{id}覆盖model 中id")
                .termsOfServiceUrl("/medi")
                .version("1.0.0")
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "",//validatorUrl",// url
                "none",
                "alpha",
                "schema",
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                true,
                true,
                60000L);
    }

}
