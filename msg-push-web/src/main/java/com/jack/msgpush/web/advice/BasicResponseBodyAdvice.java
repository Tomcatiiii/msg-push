package com.jack.msgpush.web.advice;


import com.jack.msgpush.common.vo.BasicResultVO;
import com.jack.msgpush.web.annotation.BasicResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 包装通用返回结构体
 */
@ControllerAdvice(basePackages = "com.jack.msgpush.web.controller")
public class BasicResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final String RETURN_CLASS = "BasicResultVO";


    /**
     * 判断当前类或方法有没有被注解修饰
     * @param methodParameter
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.getContainingClass().isAnnotationPresent(BasicResult.class) || methodParameter.hasMethodAnnotation(BasicResult.class);
    }

    /**
     * 如果返回对象不是BasicResultVO，则包装成BasicResultVO
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (Objects.nonNull(body) && Objects.nonNull(body.getClass())) {
            if (RETURN_CLASS.equalsIgnoreCase(body.getClass().getSimpleName())) {
                return body;
            }
        }

        return BasicResultVO.success(body);
    }
}
