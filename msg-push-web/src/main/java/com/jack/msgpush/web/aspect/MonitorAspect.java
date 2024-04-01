package com.jack.msgpush.web.aspect;


import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.jack.msgpush.web.vo.RequestLog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.PrintRequestAttribute;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Aspect
@Component
public class MonitorAspect {

    private static final String REQUEST_ID_KEY = "request_id";

    @Autowired
    private HttpServletRequest request;


    @Pointcut("@within(com.jack.msgpush.web.annotation.Monitor) || @annotation(com.jack.msgpush.web.annotation.Monitor)")
    public void executeService() {
    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        this.printRequestLog(signature, joinPoint.getArgs());
    }

    /**
     * 打印请求日志
     * @param signature
     * @param args
     */
    private void printRequestLog(MethodSignature signature, Object[] args) {
        RequestLog requestLog = new RequestLog();
        requestLog.setId(IdUtil.fastUUID());
        request.setAttribute(REQUEST_ID_KEY, requestLog.getId());
        requestLog.setUri(request.getRequestURI());
        requestLog.setMethod(request.getMethod());
        List<Object> filteredArgs = Lists.newArrayList();
        Arrays.stream(args).forEach(e -> {
            if (e instanceof MultipartFile || e instanceof HttpServletRequest
            || e instanceof HttpServletResponse || e instanceof BindingResult) {
                return;
            }

            filteredArgs.add(e);
        });

        requestLog.setArgs(filteredArgs.toArray());
        requestLog.setPath(signature.getDeclaringTypeName() + "." + signature.getMethod().getName());
        requestLog.setRemoteAddr(request.getRemoteAddr());
        requestLog.setReferer(request.getHeader("referer"));
        requestLog.setUserAgent(request.getHeader("user-agent"));
        log.info(JSON.toJSONString(requestLog));
    }
}
