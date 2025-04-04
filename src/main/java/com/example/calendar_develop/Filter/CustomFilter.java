package com.example.calendar_develop.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestURI = request.getRequestURI();

        // "중간에 가져온 URI 를 기록하는 로그"를 저장
        log.info("request URI={}", requestURI);

        // request 와 response 를 넘김
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
