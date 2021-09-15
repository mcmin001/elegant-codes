package com.elegant.codes.web.core;


import com.elegant.codes.common.constants.Constants;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogTraceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // "traceId"
        MDC.put(Constants.LOG_TRACE_ID, TraceLogUtils.getTraceId());
        return true;
    }
}
