package com.jack.msgpush.web.config;




//@ApiModel
//@EnableOpenApi
//@Component
//public class SwaggerConfiguration {
//    /**
//     * 对C端用户的接口文档
//     * <p>
//     * 地址：http://localhost:8080/swagger-ui/index.html
//     *
//     * @return
//     */
//    @Bean
//    public Docket webApiDoc() {
//        return new Docket(DocumentationType.OAS_30)
//                .groupName("接口文档")
//                .pathMapping("/")
//                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
//                .enable(true)
//                //配置文档的元信息
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.jack.msgpush.web.controller"))
//                //正则匹配请求路径，并分配到当前项目组
//                //.paths(PathSelectors.ant("/api/**"))
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("msg-push平台")
//                .description("消息推送接口接口文档")
//                .contact(new Contact("jack", "", "17744524411@qq.com"))
//                .version("v1.0")
//                .build();
//    }
//}
